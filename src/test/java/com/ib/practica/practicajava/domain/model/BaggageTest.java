package com.ib.practica.practicajava.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BaggageTest {

    @Test
    void createValidBaggage() {
        LocalDateTime now = LocalDateTime.now();
        Baggage baggage = new Baggage("FLIGHT123", "PASSENGER1", now);
        assertNotNull(baggage.getId());
        assertEquals("FLIGHT123", baggage.getFlightCode());
        assertEquals("PASSENGER1", baggage.getPassengerCode());
        assertEquals(BaggageStatus.CHECKED_IN, baggage.getStatus());
    }

    @Test
    void createBaggageWithNullCheckInDate() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            new Baggage("FLIGHT123", "PASSENGER1", null)
        );
        assertEquals("Check-in date cannot be null", ex.getMessage());
    }

    @Test
    void setCollectionDateBeforeCheckIn() {
        LocalDateTime now = LocalDateTime.now();
        Baggage baggage = new Baggage("FLIGHT123", "PASSENGER1", now);
        LocalDateTime before = now.minusHours(1);
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
            baggage.setCollectionDate(before)
        );
        assertEquals("Collection date must be after check-in date", ex.getMessage());
    }

    @Test
    void updateStatus() {
        Baggage baggage = new Baggage("FLIGHT123", "PASSENGER1", LocalDateTime.now());
        baggage.updateStatus(BaggageStatus.IN_HOLD);
        assertEquals(BaggageStatus.IN_HOLD, baggage.getStatus());
    }
}