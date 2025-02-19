package com.arrayshuffle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayShuffleTest {

    @Test
    void generateRandomInteger_whenMinIsZeroAndMaxIsZero_returnZero() {
        assertThrows(IllegalArgumentException.class, () ->  ArrayShuffle.generateRandomInteger(0, 0));
    }

    @Test
    void generateRandomInteger_whenMinIsZeroAndMaxIsOne_returnZero() {
        assertEquals(0, ArrayShuffle.generateRandomInteger(0, 1));
    }

    @Test
    void generateRandomInteger_whenMinIsOneAndMaxIsOne_returnOne() {
        int result = ArrayShuffle.generateRandomInteger(1, 7);
        System.out.println(result);
        assertTrue(result >= 1 && result <= 6);
    }

    @Test
    void shuffle_whenArrayIsNull_returnNull() {
        assertThrows(IllegalArgumentException.class, () ->  ArrayShuffle.shuffle(null));
    }

    @Test
    void shuffle_whenArrayIsEmpty_returnEmptyArray() {
        Integer[] array = new Integer[0];
        Integer[] result = ArrayShuffle.shuffle(array);
        assertEquals(0, result.length);
    }

    @Test
    void shuffle_whenArrayHasOneElement_returnSameArray() {
        Integer[] array = new Integer[]{1};
        Integer[] result = ArrayShuffle.shuffle(array);
        assertArrayEquals(array, result);
    }

    @Test
    void shuffle_whenArrayHasFiveElements_returnShuffledArray() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        Integer[] shuffle = ArrayShuffle.shuffle(array);
        System.out.println(Arrays.toString(shuffle));

        assertAll(
                () -> assertFalse(Arrays.equals(array, shuffle)),
                () ->  {
                    Arrays.sort(shuffle);
                    assertArrayEquals(array, shuffle, "Sorted shuffled array should be equal to the original");
                }
        );
    }
}