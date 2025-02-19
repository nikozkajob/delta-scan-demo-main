package com.hundreddoors;

import java.util.ArrayList;
import java.util.List;

public class HundredDoors {

    private static final int NUMBER_OF_DOORS = 100;

    public static boolean[] openDoorsByNumber(int number) {
        boolean[] doors = new boolean[NUMBER_OF_DOORS];

        for (int step = 1; step <= number; step++) {
          changeDoorsState(doors, step);
        }
        return doors;
    }

    private static void changeDoorsState(boolean[] doors, int step) {
        for (int door = step - 1; door < NUMBER_OF_DOORS; door += step) {
            doors[door] = !doors[door];
        }
    }

    public static List<Integer> getOpenDoorsNumbers() {
        boolean[] booleans = openDoorsByNumber(NUMBER_OF_DOORS);
        List<Integer> openDoorsNumbers = new ArrayList<>(10);
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                openDoorsNumbers.add(i + 1);
            }
        }
        return openDoorsNumbers;
    }
}
