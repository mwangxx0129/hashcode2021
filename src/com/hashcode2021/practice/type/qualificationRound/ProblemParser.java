package com.hashcode2021.practice.type.qualificationRound;



import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProblemParser {
    private int index;
    private Problem result = new Problem();
    private List<String> lines = new LinkedList<>();

//    private Map<Pizza, Set<String>> pizzaIngredients = new ConcurrentHashMap<>();
//    Duration
//    Number of intersection
//    Number of streets
//    Number of car
//    Map<StreeName, Street>
//    Map<CarName, Car>
//    Map<Intersection ID, Intersection>


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

            assert nums.size() == 5;

            result.setDuration(nums.get(0));
            result.setNumIntersections(nums.get(1));
            result.setNumStreets(nums.get(2));
            result.setNumCars(nums.get(3));
            result.setPoints(nums.get(4));
        } else if (index > 0 && index <= result.getNumStreets()){
            final var nums = Arrays.stream(line.split(" "))
                    .collect(Collectors.toUnmodifiableList());

            // Parse street and intersection definition
            AtomicInteger idx = new AtomicInteger();
            Intersection start = result.intersectionsMap.getOrDefault(Integer.parseInt(nums.get(0)), new Intersection(Integer.parseInt(nums.get(0))));
            Intersection end = result.intersectionsMap.getOrDefault(Integer.parseInt(nums.get(1)), new Intersection(Integer.parseInt(nums.get(1))));

            // To create street, create start and end intersections first
            result.intersectionsMap.put(Integer.parseInt(nums.get(0)), start);
            result.intersectionsMap.put(Integer.parseInt(nums.get(1)), end);

            Street street = new Street(idx.get(), start, end, nums.get(2), Integer.parseInt(nums.get(3)));
            result.idToStreets.put(idx.get(), street);
            result.nameToStreets.put(nums.get(2), street);
            result.streetToIds.put(nums.get(2), idx.getAndIncrement());

            // post process
            start.getOutgoingStreet().add(street.getName());
            end.getIncomingStreet().add(street.getName());

        } else {
            // Parse car definition
            AtomicInteger idx = new AtomicInteger();

            final var streetList = Arrays.stream(line.split(" "))
                    .skip(1)
                    .map(e -> result.nameToStreets.get(e))
                    .collect(Collectors.toUnmodifiableList());
            result.carsMap.put(idx.get(), new Car(idx.getAndIncrement(), streetList, streetList.size(), false, -1));
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
    }

    private void postprocess() {

    }
}
