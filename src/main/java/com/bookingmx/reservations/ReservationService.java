package com.bookingmx.reservations;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Concrete implementation of the reservation service.
 * This class handles the business logic for managing reservations and uses an in-memory
 * map to store the data for this demonstration.
 */
public class ReservationService implements IReservationService {

    /**
     * In-memory storage for reservations.
     * The key is the reservation ID (String), and the value is the Reservation object.
     */
    private final Map<String, Reservation> reservations = new HashMap<>();

    @Override
    public Reservation createReservation(String guestName) {
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new IllegalArgumentException("Guest name cannot be empty.");
        }
        String reservationId = UUID.randomUUID().toString();
        Reservation newReservation = new Reservation(reservationId, guestName);
        reservations.put(reservationId, newReservation);
        return newReservation;
    }

    @Override
    public Reservation getReservation(String id) {
        return reservations.get(id);
    }

    @Override
    public Reservation editGuestName(String id, String newGuestName) {
        Reservation reservation = getReservation(id);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation with ID " + id + " not found.");
        }
        if (newGuestName == null || newGuestName.trim().isEmpty()) {
            throw new IllegalArgumentException("New guest name cannot be empty.");
        }
        // This line was added to fix a bug discovered during unit testing.
        reservation.setGuestName(newGuestName);
        return reservation;
    }

    @Override
    public void cancelReservation(String id) {
        Reservation reservation = getReservation(id);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation with ID " + id + " not found.");
        }
        if (reservation.getStatus() == Reservation.Status.CANCELLED) {
            throw new IllegalStateException("Reservation is already cancelled.");
        }
        reservation.setStatus(Reservation.Status.CANCELLED);
    }
}