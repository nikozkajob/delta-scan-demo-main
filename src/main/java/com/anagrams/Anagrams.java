package com.anagrams;


import java.util.ArrayList;
import java.util.List;

//Write a program to generate all potential anagrams of an input string.
//
//For example, the potential anagrams of "biro" are
//
//biro bior brio broi boir bori
//ibro ibor irbo irob iobr iorb
//rbio rboi ribo riob roib robi
//obir obri oibr oirb orbi orib
public class Anagrams {

//    public static List<String> makeListOfAnagrams(String input) {
//        if (input.length() == 1) return List.of(input);
//        List<String> result = new ArrayList<>();
//
//        String[] split = input.split("");
//        String[] first = new String[]{split[0], split[split.length - 1]};
//        String[] second = new String[]{split[0], split[split.length - 2]};
//        for (int i = 0; i < input.length(); i++) {
//            String[] third = new String[]{split[split.length - i  ], split[split.length - 2 - i]};
//            result.add(split[i] + buildCombination(third));
//            result.add(split[i] + buildCombination2(third));
//            System.out.println(result);
//
//
//        }
//// a 0  b 1  c 2   length = 3
//
//        return result;
//    }

    public static List<String> makeListOfAnagrams(String input) {
        List<String> result = new ArrayList<>();
        generateAnagrams("", input, result);
        return result;
    }

    private static void generateAnagrams(String prefix, String remaining, List<String> result) {
        System.out.println("<" + prefix + ">");
        System.out.println("remaining: " + remaining);

        if (remaining.isEmpty()) {
            result.add(prefix);
            System.out.println("result: " + result);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                generateAnagrams(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result);
            }
        }
    }


}
