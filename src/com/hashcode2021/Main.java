package com.hashcode2021;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        String dir = "/Users/xinxin/Desktop/";
        String A = dir + "a_example";
        String B = dir + "b_little_bit_of_everything.in";
        List<String> lines = FileReader.readFromInputStream(new FileInputStream(B));
        InputParser.parse(lines);
        List<List<String>> pizzaIngList = InputParser.pizzaIngList;
        Map<Integer, Integer> teamTypeWithNum = InputParser.teamTypeWithNum;
        InputParser.print();
        Deliver.deliver3(pizzaIngList, teamTypeWithNum);
    }
}
