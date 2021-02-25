package com.hashcode2021.practice;


import com.hashcode2021.FileReader;
import com.hashcode2021.practice.solver.GreedySolver;
import com.hashcode2021.practice.type.Problem;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        assert args.length == 1;

        String dir = "/Users/xinxin/Desktop/";
        String A = "a_example";
        String B = "b_little_bit_of_everything.in";
        String C = "c_many_ingredients.in.txt";

        List<String> lines = readFromInputStream(new FileInputStream(dir + C));
        drive("C", lines, new ProblemParser());
    }

    private static void drive(String prefix, List<String> lines, ProblemParser parser) {
        System.out.println("Parsing input ...\n");
        for (String line : lines) {
            parser.feedLine(line);
        }

        final var configs = configCombinations();

        for (int i = 0; i < configs.length; i++) {
            final var problem = i == 0 ? parser.get() : parser.replayed().get();
            System.out.println(problem.summarize());

            System.out.printf("Solving (%d of %d) ...\n", i + 1, configs.length);
            final var start = Instant.now();
            final var solver = new GreedySolver(configs[i]);
            problem.solve(solver);
            assert problem.isSolved();
            final var end = Instant.now();
            System.out.printf("Solved after %s.\n\n", Duration.between(start, end).toString());

            System.out.println("Validating result ...\n");
            assert problem.isValid();

            System.out.printf("Solved. Score is %.0f.\n\n", problem.getScore());

            dump(prefix, problem);
        }
    }

    private static void dump(String prefix, Problem problem) {
        assert problem.isSolved();

        final var fileName = "solution_%s_%.0f.txt".formatted(prefix, problem.getScore());
        try {
            Files.write(
                    Path.of(fileName),
                    problem.toString().getBytes(),
                    StandardOpenOption.CREATE
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static GreedySolver.Config[] configCombinations() {
        return new GreedySolver.Config[]{
                new GreedySolver.Config(true, true),
                new GreedySolver.Config(true, false),
                new GreedySolver.Config(false, false),
                new GreedySolver.Config(false, true),
        };
    }

    public static List readFromInputStream(InputStream inputStream)
            throws IOException {
        List<String> lines = new LinkedList<>();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
