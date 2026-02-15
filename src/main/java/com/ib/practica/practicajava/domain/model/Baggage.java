package com.ib.practica.practicajava.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Baggage {

    private UUID id;
    private String flightCode;
    private String passengerCode;
    private LocalDateTime checkInDate;
    private LocalDateTime collectionDate;
    private BaggageStatus status;

    public Baggage(String flightCode, String passengerCode, LocalDateTime checkInDate) {
        this.id = UUID.randomUUID();
        this.flightCode = flightCode;
        this.passengerCode = passengerCode;
        this.checkInDate = checkInDate;
        this.status = BaggageStatus.CHECKED_IN;
        validateDates();
    }

    public void updateStatus(BaggageStatus newStatus) {
        this.status = newStatus;
    }

    public void setCollectionDate(LocalDateTime collectionDate) {
        this.collectionDate = collectionDate;
        validateDates();
    }

    private void validateDates() {
        if (checkInDate == null) {
            throw new IllegalArgumentException("Check-in date cannot be null");
        }
        if (collectionDate != null && collectionDate.isBefore(checkInDate)) {
            throw new IllegalArgumentException("Collection date must be after check-in date");
        }
    }
}