package com.arrayshuffle;

import java.util.Random;

public class ArrayShuffle {


   static Random random = new Random();

    public static int generateRandomInteger(int min, int max) {
       return random.nextInt(min, max);
    }

    public static <T> T[] shuffle(T[] array) {
        if (array == null) throw new IllegalArgumentException("Input can not be null");

        T[] clone = array.clone();
        for (int i = 0; i < clone.length; i++) {
            int r = generateRandomInteger(i, clone.length);
            T temp = clone[i];
            clone[i] = clone[r];
            clone[r] = temp;
        }
        return clone;
    }
}
