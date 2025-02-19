package com.abc;
// You are given a collection of ABC blocks (maybe like the ones you had when you were a kid).
//There are twenty blocks with two letters on each block.
//A complete alphabet is guaranteed amongst all sides of the blocks.
//The sample collection of blocks:
//
// (B O)
// (X K)
// (D Q)
// (C P)
// (N A)
// (G T)
// (R E)
// (T G)
// (Q D)
// (F S)
// (J W)
// (H U)
// (V I)
// (A N)
// (O B)
// (E R)
// (F S)
// (L Y)
// (P C)
// (Z M)
//
//Task
//Write a function that takes a string (word) and determines whether the word can be spelled with the given collection of blocks.
//The rules are simple:
//   1. Once a letter on a block is used that block cannot be used again
//   2. The function should be case-insensitive
//   3. Show the output on this page for the following 7 words in the following example






import java.util.ArrayList;
import java.util.List;

public class ABC {

    private static List<String> BLOCKS = List.of(
           "BO",
           "XK",
           "DQ",
           "CP",
           "NA",
           "GT",
           "RE",
           "TG",
           "QD",
           "FS",
           "JW",
           "HU",
           "VI",
           "AN",
           "OB",
           "ER",
           "FS",
           "LY",
           "PC",
           "ZM");

    public static boolean canMakeWord(String word) {
        List<String> blocs = new ArrayList<>(BLOCKS);
        word = word.toUpperCase();

        for (int letterIndex = 0; letterIndex < word.length(); letterIndex++) {

            boolean canMakeWord = false;
            String finalWord = word;
            int finalLetterIndex = letterIndex;

            canMakeWord = blocs.stream()
                    .filter(block -> block.contains(String.valueOf(finalWord.charAt(finalLetterIndex))))
                    .findFirst()
                    .map(blocs::remove)
                    .isPresent();

//            for (String block : blocs) {
//                if (block.contains(String.valueOf(word.charAt(letterIndex)))) {
//                    blocs.remove(block);
//                    canMakeWord = true;
//                    break;
//                }
//            }
            if (!canMakeWord) {
                return false;
            }
        }

        return true;
    }
}
