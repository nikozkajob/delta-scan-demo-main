package com.aligncolumns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlignColumns {

    public static List<String> readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().toList();
        }
    }

    public static List<List<String>> splitLinesToSeparateWords(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    line = line.charAt(line.length() - 1) == '$' ? line.substring(0, line.length() - 1) : line;
                    String[] words = line.split("\\$");


                    return Arrays.asList(words);
                })
                .toList();

    }

    public static int getLongestWordLength(List<List<String>> lines) {
        return lines.stream()
                .flatMap(List::stream)
                .mapToInt(String::length)
                .max().orElse(0);
    }

    public static List<String> alignColumns(List<List<String>> lines) {
        int longestWordLength = getLongestWordLength(lines);

        return lines.stream()
                .map(line -> {
                    StringBuilder alignedLine = new StringBuilder();
                    for (int i = 0; i < line.size(); i++) {
                        String word = line.get(i);
                        if (i < line.size() - 1) {
                            alignedLine.append(word).append(" ".repeat(longestWordLength - word.length() + 1));
                        } else {
                            alignedLine.append(word);
                        }
                    }
                    return alignedLine.toString();
                })
                .toList();
    }

    public static String alignColumnsToString(List<List<String>> lines) {
        List<String> alignedLines = alignColumns(lines);
        return String.join("\n", alignedLines);
    }
}
