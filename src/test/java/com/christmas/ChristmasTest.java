package com.christmas;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasTest {

    @Test
    void getVerseHeaderTest_whenInput1_returnFirstTwoLinesOfFirstGetVerse() {
        String result = Christmas.getVerseHeader(1);
        assertEquals("""
                    On the first day of Christmas
                    My true love gave to me:
                    """,
                result);
    }

    @Test
    void getVerseHeaderTest_whenInput2_returnFirstTwoLinesOrSecondGetVerse() {
        String result = Christmas.getVerseHeader(2);
        assertEquals("""
                    On the second day of Christmas
                    My true love gave to me:
                    """,
                result);
    }
    @Test
    void getUniqueLineTest_whenInputIst1_returnFirstUniqueLine() {
        String result = "A partridge in a pear tree.";
        assertEquals(result, Christmas.getUniqueLine(1));
    }

    @Test
    void getUniqueLineTest_whenInput2_returnSecondUniqueLine() {
        String result = "Two turtle doves and";
        assertEquals(result, Christmas.getUniqueLine(2));
    }

    @Test
    void getVerseTest_whenInput1_returnFirstGetVerse() {
        String result = Christmas.getVerse(1);
        assertEquals("""
                    On the first day of Christmas
                    My true love gave to me:
                    A partridge in a pear tree.
                    """,
                result);
    }

    @Test
    void getVerseTest_whenInput2_returnSecondGetVerse() {
        String result = Christmas.getVerse(2);
        assertEquals("""
                    On the second day of Christmas
                    My true love gave to me:
                    Two turtle doves and
                    A partridge in a pear tree.
                    """,
                result);
    }

    @Test
    void getVerseTest_whenInput3_returnThirdGetVerse() {
        String result = Christmas.getVerse(3);
        assertEquals("""
                    On the third day of Christmas
                    My true love gave to me:
                    Three french hens
                    Two turtle doves and
                    A partridge in a pear tree.
                    """,
                result);
    }

    @Test
    void getAllLyricsTest_whenCalled_returnFullLyricOfAllVerses() throws IOException {
        String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/christmas_song.txt")));
        assertEquals(expected.trim(), Christmas.getSong());
    }
}