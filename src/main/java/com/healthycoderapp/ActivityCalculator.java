package com.healthycoderapp;

public class ActivityCalculator {
    private static final int WORKOUT_DURATION = 45;

    public static String rateActivityLevel(int weeklyCardioMin, int weeklyWorkoutSessions) {
        if (weeklyCardioMin < 0 || weeklyWorkoutSessions < 0) {
            throw new RuntimeException("Input cannot be negative");
        }

        int totalWorkoutMins = weeklyWorkoutSessions * WORKOUT_DURATION + weeklyCardioMin;
        int activityLevel = totalWorkoutMins / 7;

        if (activityLevel < 20) {
            return "Bad";
        } else if (activityLevel < 40 && activityLevel > 20) {
            return "Average";
        }
        return "Good";
    }
}
