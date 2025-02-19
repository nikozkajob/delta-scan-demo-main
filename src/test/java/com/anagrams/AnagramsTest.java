package com.anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    @Test
    void makeListOfAnagrams_whenOneLetter_ReturnListOfOne() {
        System.out.println("HERE" + "abc".substring(1));

        assertIterableEquals(List.of("a"), Anagrams.makeListOfAnagrams("a"));
    }

    @Test
    void makeListOfAnagrams_whenTwoLetters_ReturnListOfTwoCombinations() {
        assertIterableEquals(List.of("ab", "ba"), Anagrams.makeListOfAnagrams("ab"));
    }

    @Test
    void makeListOfAnagrams_whenThreeLetters_ReturnListOfThreeCombinations() {
        assertIterableEquals(List.of("abc", "acb", "bac", "bca", "cab", "cba"),
                Anagrams.makeListOfAnagrams("abc"));
    }

    @Test
    void makeListOfAnagrams_whenFourLetters_ReturnListOfCombinations2() {
        assertIterableEquals(List.of(
                        "biro", "bior", "brio", "broi", "boir", "bori",
                        "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                        "rbio", "rboi", "ribo", "riob", "robi", "roib",
                        "obir", "obri", "oibr", "oirb", "orbi", "orib"),
                Anagrams.makeListOfAnagrams("biro"));
    }

    @Test
    void makeListOfAnagrams_whenFiveLetters_ReturnListOfCombinations() {
        List<String> expected = List.of(
                "baker", "bakre", "baekr", "baerk", "barke", "barek",
                "bkaer", "bkare", "bkear", "bkera", "bkrae", "bkrea",
                "beakr", "beark", "bekar", "bekra", "berak", "berka",
                "brake", "braek", "brkae", "brkea", "break", "breka",
                "abker", "abkre", "abekr", "aberk", "abrke", "abrek",
                "akber", "akbre", "akebr", "akerb", "akrbe", "akreb",
                "aebkr", "aebrk", "aekbr", "aekrb", "aerbk", "aerkb",
                "arbke", "arbek", "arkbe", "arkeb", "arebk", "arekb",
                "kbaer", "kbare", "kbear", "kbera", "kbrae", "kbrea",
                "kaber", "kabre", "kaebr", "kaerb", "karbe", "kareb",
                "kebar", "kebra", "keabr", "kearb", "kerba", "kerab",
                "krbae", "krbea", "krabe", "kraeb", "kreba", "kreab",
                "ebakr", "ebark", "ebkar", "ebkra", "ebrak", "ebrka",
                "eabkr", "eabrk", "eakbr", "eakrb", "earbk", "earkb",
                "ekbar", "ekbra", "ekabr", "ekarb", "ekrba", "ekrab",
                "erbak", "erbka", "erabk", "erakb", "erkba", "erkab",
                "rbake", "rbaek", "rbkae", "rbkea", "rbeak", "rbeka",
                "rabke", "rabek", "rakbe", "rakeb", "raebk", "raekb",
                "rkbae", "rkbea", "rkabe", "rkaeb", "rkeba", "rkeab",
                "rebak", "rebka", "reabk", "reakb", "rekba", "rekab");


        List<String> actual = Anagrams.makeListOfAnagrams("baker");
        System.out.println(actual);
        assertIterableEquals(expected, actual);
    }
}


