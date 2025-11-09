package com.bookingmx.reservations;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementación concreta del servicio de reservaciones.
 * Utiliza un mapa en memoria para almacenar los datos.
 */
public class ReservationService implements IReservationService {

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
        reservation.setGuestName(newGuestName);
        /* ya se arregló
        // ¡ERROR INTENCIONAL! Esta línea falta para que la descubras con tus pruebas.
        // reservation.setGuestName(newGuestName);*/
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