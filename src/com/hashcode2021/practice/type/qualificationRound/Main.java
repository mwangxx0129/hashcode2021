package com.hashcode2021.practice.type.qualificationRound;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        assert args.length == 1;

        String dir = "/Users/xinxin/Desktop/";
        String A = "a.txt";

        List<String> lines = readFromInputStream(new FileInputStream(dir + A));
        drive("A", lines, new ProblemParser());
    }

    public static void drive(String prefix, List<String> lines, ProblemParser parser) {
        System.out.println("Parsing input ...\n");
        for (String line : lines) {
            parser.feedLine(line);
        }
        parser.get().summarize();
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
