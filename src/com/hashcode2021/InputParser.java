package com.hashcode2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputParser {
    //5 1 2 1
    //3 onion pepper olive
    //3 mushroom tomato basil
    //3 chicken mushroom pepper
    //3 tomato mushroom basil
    //2 chicken basil
    static int numberOfPizza;
    static List<List<String>> pizzaIngList = new ArrayList<>();
    static Map<Integer, Integer> teamTypeWithNum = new HashMap<>();

    public static void parse(List<String> lines) {
        try {
            String[] tokens = lines.get(0).split("\\s+");
            numberOfPizza = Integer.parseInt(tokens[0]);
            teamTypeWithNum.put(2, Integer.parseInt(tokens[1]));
            teamTypeWithNum.put(3, Integer.parseInt(tokens[2]));
            teamTypeWithNum.put(4, Integer.parseInt(tokens[3]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numberOfPizza; ++ i) {
            String line = lines.get(i + 1);
            String[] tokens = line.split("\\s+");
            List<String> ing = new ArrayList<>();
            for (int j = 1; j < tokens.length; ++ j) {
                ing.add(tokens[j]);
            }
            pizzaIngList.add(ing);
        }
    }

    public static void print() {
        System.out.println(pizzaIngList);
        System.out.println(teamTypeWithNum);
    }
}
