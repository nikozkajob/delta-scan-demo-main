package com.bestshuffle;

//Display the result as follows:
//
//        original string, shuffled string, (score)
//
//The score gives the number of positions whose character value did not change.
//
//        Example
//tree, eetr, (0)
//
//Test cases
//abracadabra
//        seesaw
//elk
//        grrrrrr
//up
//        a

import com.arrayshuffle.ArrayShuffle;
import com.arrayshuffle.ShuffleScore;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Arrays;

public class BestShuffle {
//todo comment
    public static ShuffleScore getShuffleScore(String s) {

        if(s == null) {
            throw new IllegalArgumentException("Input can not be null");
        }
        Character[] array = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        Character[] shuffledChars = ArrayShuffle.shuffle(array);

        int score = 0;
        for (int i = 0; i < shuffledChars.length; i++) {
            if (array[i].equals(shuffledChars[i])) {
                score++;
            }
        }

        return new ShuffleScore(s, Arrays.toString(shuffledChars), score);
    }
}
