package com.healthycoderapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BMICalculatorTest {
@Nested
class IsDietRecommendedTest {
    @ParameterizedTest
    @ValueSource(doubles = { 89, 95,110})
    void isDietRecommended_shouldReturnTrue_whenBMIIsAboveThreshold(double weight) {
        assertTrue(BMICalculator.isDietRecommended(weight, 1.72));
    }

    @ParameterizedTest(name = "weight = {0}, height = {1}")
    @CsvSource(value = {"40,1.72", "43,1.75", "50,1.72"}, delimiter = ',')
    void isDietRecommended_shouldReturnFalse_whenBMIIsBelowThreshold(double weight, double height) {
        assertFalse(BMICalculator.isDietRecommended(weight, height));
    }

    @ParameterizedTest(name = "weight = {0}, height = {1}")
    @CsvFileSource(resources = "/weightAndHeight.csv", numLinesToSkip = 1, delimiterString = ",")
    void isDietRecommended_shouldThrowException_whenHeightIsZero(double weight, double height) {
        assertThrows(ArithmeticException.class,
                () -> BMICalculator.isDietRecommended(weight, height));
    }
}

@Nested
class FindCoderWithWorstBMITest {

    @Test
    void findCoderWithWorstBMI_shouldReturnCoderWithWorstBMI_whenListHas10000Elements() {
        List<Coder> coders = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            coders.add(new Coder(1.0 + i, 10.0 + i));
        }
        assertTimeout(Duration.ofMillis(20), () -> BMICalculator.findCoderWithWorstBMI(coders));
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void findCoderWithWorstBMI_shouldReturnCoderWithWorstBMI_whenListIsNotEmpty() {
        List<Coder> coders = List.of(
                new Coder(1.5, 80.0),
                new Coder(1.6, 70.0),
                new Coder(1.7, 60.0),
                new Coder(1.8, 50.0),
                new Coder(1.9, 40.0)
        );

        assertAll(
                () -> assertEquals(coders.get(0).getHeight(), BMICalculator.findCoderWithWorstBMI(coders).getHeight()),
                () -> assertEquals(coders.get(0).getWeight(), BMICalculator.findCoderWithWorstBMI(coders).getWeight())
        );
    }
    @Test
    void findCoderWithWorstBMI_shouldReturnNull_whenListIsEmpty() {
        List<Coder> coders = List.of();

        assertNull(BMICalculator.findCoderWithWorstBMI(coders));
    }
}

@Nested
class GetBMIScoresTest {

    @Test
//    @Disabled
    @DisabledOnOs(value = OS.LINUX)
    void getBMIScores_shouldReturnArrayOfBMIScores_whenListIsNotEmpty() {
        List<Coder> coders = List.of(
                new Coder(1.5, 80.0),
                new Coder(1.6, 70.0),
                new Coder(1.7, 60.0)
        );

        double[] expected = {35.56, 27.34, 20.76};

        assertArrayEquals(expected, BMICalculator.getBMIScores(coders));
    }
}
}