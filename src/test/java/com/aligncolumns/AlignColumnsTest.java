package com.aligncolumns;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlignColumnsTest {
    private static final String FILE_PATH = "src/test/resources/alignColumns";

    @Test
    void readFromFile_whenFileIsValid_returnsListOfStringsLines() throws IOException {
        List<String> expectedResult = List.of(
                "Given$a$text$file$of$many$lines,$where$fields$within$a$line$",
                "are$delineated$by$a$single$'dollar'$character,$write$a$program",
                "that$aligns$each$column$of$fields$by$ensuring$that$words$in$each$",
                "column$are$separated$by$at$least$one$space");

        assertIterableEquals(expectedResult, AlignColumns.readFromFile(FILE_PATH));
        assertIterableEquals(expectedResult, AlignColumns.readFromFile(FILE_PATH));
        assertIterableEquals(expectedResult, AlignColumns.readFromFile(FILE_PATH));
        assertIterableEquals(expectedResult, AlignColumns.readFromFile(FILE_PATH));
    }

    @Test
    void splitLinesToSeparateWords() throws IOException {
        List<String> expectedFirstLine = List.of("Given", "a", "text", "file", "of", "many", "lines,", "where", "fields", "within", "a", "line");
        List<String> strings = AlignColumns.splitLinesToSeparateWords(AlignColumns.readFromFile(FILE_PATH)).get(0);
        System.out.println(strings);
        assertIterableEquals(expectedFirstLine,
                strings);
    }

    @Test
    void getLongestWordLength() throws IOException {
        assertEquals(10, AlignColumns.getLongestWordLength(
                AlignColumns.splitLinesToSeparateWords(
                        AlignColumns.readFromFile(FILE_PATH))));
    }

    @Test
    void alignColumns() throws IOException {
        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/alignColumnsResult")));
        System.out.println(expected);
        assertEquals(expected,
                AlignColumns.alignColumnsToString(
                        AlignColumns.splitLinesToSeparateWords(
                                AlignColumns.readFromFile(FILE_PATH))));
    }
}

