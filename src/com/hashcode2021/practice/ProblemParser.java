package com.hashcode2021.practice;

import com.hashcode2021.practice.type.Pizza;
import com.hashcode2021.practice.type.Problem;
import com.hashcode2021.practice.type.Team;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemParser {
    private int index;
    private Problem result = new Problem();
    private List<String> lines = new LinkedList<>();
    private Map<Pizza, Set<String>> pizzaIngredients = new ConcurrentHashMap<>();

    public void feedLine(String line) {
        lines.add(line);
        processLine(line);
    }

    private void processLine(String line) {
        if (index == 0) {
            // Parse first meta data line
            final var nums = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toUnmodifiableList());

            assert nums.size() == 4;

            result.setNumPizzas(nums.get(0));
            result.setNumTwoTeams(nums.get(1));
            result.setNumThreeTeams(nums.get(2));
            result.setNumFourTeams(nums.get(3));

            IntStream.range(0, result.getNumTwoTeams())
                    .mapToObj(i -> new Team(i, 2))
                    .forEach(result::addTeam);
            IntStream.range(0, result.getNumThreeTeams())
                    .mapToObj(i -> new Team(i, 3))
                    .forEach(result::addTeam);
            IntStream.range(0, result.getNumFourTeams())
                    .mapToObj(i -> new Team(i, 4))
                    .forEach(result::addTeam);
        } else {
            // Parse pizza definition
            final var pizza = new Pizza(index - 1);
            final var ingredients = Arrays.stream(line.split(" "))
                    .skip(1)
                    .collect(Collectors.toUnmodifiableSet());
            pizzaIngredients.put(pizza, ingredients);
            result.addPizza(pizza);
        }

        index++;
    }

    public Problem get() {
        postprocess();
        return result;
    }

    public ProblemParser replayed() {
        assert !lines.isEmpty();

        reset();
        lines.forEach(this::processLine);
        return this;
    }

    private void reset() {
        index = 0;
        result = new Problem();
        pizzaIngredients.clear();
    }

    private void postprocess() {
        final var idx = new AtomicInteger();
        final var ingredientIdxMap = pizzaIngredients.values().stream()
                .flatMap(Collection::stream)
                .unordered()
                .distinct()
                .collect(Collectors.toMap(s -> s, s -> idx.getAndIncrement()));

        result.getPizzas().stream()
                .unordered()
                .parallel()
                .forEach(p -> {
                    final var ingredients = new BitSet(idx.get() + 1);
                    pizzaIngredients.get(p).forEach(ing -> ingredients.set(ingredientIdxMap.get(ing)));
                    p.setIngredients(ingredients);
                });

        Team.totalIngredients = idx.get();
    }
}
