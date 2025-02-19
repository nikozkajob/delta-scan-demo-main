package com.realestateapp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    private static final double MAX_MULTIPLIER = 4.0;

    @Test
    void generate_defaultConstructor_ReturnsCorrectApartment() {
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator();
        assertNotNull(randomApartmentGenerator.generate());

    }
    @Test
    void generate_withConstructor_ReturnsCorrectApartment() {
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator(30,
                new BigDecimal(3000.0));
        assertNotNull(randomApartmentGenerator.generate());

    }

    @Test
    void generate_defaultConstructor_ReturnsApartmentWithinExpectedRange() {
        RandomApartmentGenerator generator = new RandomApartmentGenerator();
        Apartment apartment = generator.generate();

        double minArea = 30.0;
        double maxArea = minArea * RandomApartmentGeneratorTest.MAX_MULTIPLIER;
        BigDecimal minPricePerSquareMeter = new BigDecimal(3000.0);
        BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(RandomApartmentGeneratorTest.MAX_MULTIPLIER));

        assertTrue(apartment.getArea() >= minArea && apartment.getArea() <= maxArea);
        assertTrue(apartment.getPrice().compareTo(minPricePerSquareMeter.multiply(new BigDecimal(apartment.getArea()))) >= 0);
        assertTrue(apartment.getPrice().compareTo(maxPricePerSquareMeter.multiply(new BigDecimal(apartment.getArea()))) <= 0);
    }

    @Test
    void generate_customConstructor_ReturnsApartmentWithinExpectedRange() {
        double minArea = 20.0;
        BigDecimal minPricePerSquareMeter = new BigDecimal(2000.0);
        RandomApartmentGenerator generator = new RandomApartmentGenerator(minArea, minPricePerSquareMeter);
        Apartment apartment = generator.generate();

        double maxArea = minArea * RandomApartmentGeneratorTest.MAX_MULTIPLIER;
        BigDecimal maxPricePerSquareMeter = minPricePerSquareMeter.multiply(new BigDecimal(RandomApartmentGeneratorTest.MAX_MULTIPLIER));

        assertTrue(apartment.getArea() >= minArea && apartment.getArea() <= maxArea);
        assertTrue(apartment.getPrice().compareTo(minPricePerSquareMeter.multiply(new BigDecimal(apartment.getArea()))) >= 0);
        assertTrue(apartment.getPrice().compareTo(maxPricePerSquareMeter.multiply(new BigDecimal(apartment.getArea()))) <= 0);
    }
}