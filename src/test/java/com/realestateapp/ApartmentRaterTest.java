package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {

  @Test
    void rateApartment_IncorrectApartment_ReturnErrorValue() {
        Apartment apartment = new Apartment(0, new BigDecimal(0));

        assertEquals(-1, ApartmentRater.rateApartment(apartment));
    }
    @Test
    void rateApartment_CheapApartment_ReturnRating0() {
        Apartment apartment = new Apartment(30, new BigDecimal(100_000));
        assertEquals(0, ApartmentRater.rateApartment(apartment));
    }

    @Test
    void rateApartment_ModerateApartment_ReturnRating1() {
        Apartment apartment = new Apartment(30, new BigDecimal(200_000));
        assertEquals(1, ApartmentRater.rateApartment(apartment));
    }

    @Test
    void rateApartment_ExpensiveApartment_ReturnRating2() {
        Apartment apartment = new Apartment(30, new BigDecimal(300_000));
        assertEquals(2, ApartmentRater.rateApartment(apartment));
    }

    @Test
    void calculateAverageRating_EmptyList_ThrowExceptionInCalculateAverageRating() {
        List<Apartment> emptyList = new ArrayList<>();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ApartmentRater.calculateAverageRating(emptyList));
        assertEquals(exception.getMessage(), "Cannot calculate average rating for empty list");
    }


    @Test
    void calculateAverageRating_CorrectList_CalculateCorrectAverage() {
      List<Apartment> apartmentList = List.of(
              new Apartment(30, new BigDecimal(100_000)),
              new Apartment(30, new BigDecimal(200_000)),
              new Apartment(30, new BigDecimal(300_000)));

      assertEquals(1.0, ApartmentRater.calculateAverageRating(apartmentList));
    }
}