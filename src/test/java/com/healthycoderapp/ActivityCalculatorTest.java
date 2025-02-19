package com.healthycoderapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityCalculatorTest {

    @Test
    void rateActivityLevel_whenAvarageIsBelow20_shouldReturnBad() {
        int weeklyCardioMin = 40;
        int weeklyWorkoutSessions = 1;

        assertEquals("Bad", ActivityCalculator.rateActivityLevel(weeklyCardioMin, weeklyWorkoutSessions));
    }

    @Test
    void rateActivityLevel_whenAvarageIsBetween20and40_shouldReturnAverage() {
        int weeklyCardioMin = 40;
        int weeklyWorkoutSessions = 3;
        assertEquals("Average", ActivityCalculator.rateActivityLevel(weeklyCardioMin, weeklyWorkoutSessions));
    }

    @Test
    void rateActivityLevel_whenAvarageIsAbove40_shouldReturnGood() {
        int weeklyCardioMin = 40;
        int weeklyWorkoutSessions = 7;
        assertEquals("Good", ActivityCalculator.rateActivityLevel(weeklyCardioMin, weeklyWorkoutSessions));
    }

    @Test
    void rateActivityLevel_whenInputBelow0_thenThrowException() {
        int weeklyCardioMin = -40;
        int weeklyWorkoutSessions = 7;

        assertThrows(RuntimeException.class, () -> ActivityCalculator.rateActivityLevel(weeklyCardioMin, weeklyWorkoutSessions));
    }
}