package com.hundreddoors;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hundreddoors.HundredDoors.openDoorsByNumber;
import static org.junit.jupiter.api.Assertions.*;

class HundredDoorsTest {

    private static final int NUMBER_OF_DOORS = 100;

    private static final boolean[] DOORS = new boolean[100];

    static {
        Arrays.fill(DOORS, true);
    }

    @Test
    void getNumberOfOpenDoorsTest_whenInput1_shouldReturnAllTrue() {
        assertArrayEquals(DOORS, HundredDoors.openDoorsByNumber(1));
    }

    @Test
    void getNumberOfOpenDoors_whenInput2_shouldReturnEach2DoorOpen() {
        boolean[] doors = {
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false,
                true, false, true, false, true, false, true, false, true, false};

        assertArrayEquals(doors, openDoorsByNumber(2));
    }

    @Test
    void getNumberOfOpenDoorsTest_whenInput3_shouldReturnEach3DoorOpenAndEach3Closed() {
        boolean[] expectedDoors = {
                true, false, false, false, true, true, true, false, false, false,
                true, true, true, false, false, false, true, true, true, false,
                false, false, true, true, true, false, false, false, true, true,
                true, false, false, false, true, true, true, false, false, false,
                true, true, true, false, false, false, true, true, true, false,
                false, false, true, true, true, false, false, false, true, true,
                true, false, false, false, true, true, true, false, false, false,
                true, true, true, false, false, false, true, true, true, false,
                false, false, true, true, true, false, false, false, true, true,
                true, false, false, false, true, true, true, false, false, false
        };

        boolean[] actualDoors = openDoorsByNumber(3);
        assertArrayEquals(expectedDoors, actualDoors);
    }

    @Test
    void openDoorsByNumberTest_whenInput2_shouldReturnEach2DoorOpen() {

        boolean[] result = openDoorsByNumber(NUMBER_OF_DOORS);

        boolean[] expectedState = new boolean[100];
        expectedState[0] = true;
        expectedState[3] = true;
        expectedState[8] = true;
        expectedState[15] = true;
        expectedState[24] = true;
        expectedState[35] = true;
        expectedState[48] = true;
        expectedState[63] = true;
        expectedState[80] = true;
        expectedState[99] = true;

        for (int i = 0; i < expectedState.length; i++) {
            assertEquals(expectedState[i], result[i],
                    "Door " + (i + 1) + " should be " + (expectedState[i] ? "open" : "closed"));
        }
    }
    @Test
    void getOpenDoorsNumbers_whenPass100and100doors_return() {
        List<Integer> expected = List.of(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);

        List<Integer> openDoorsNumbers = HundredDoors.getOpenDoorsNumbers();

        assertIterableEquals(expected, openDoorsNumbers);
    }
}