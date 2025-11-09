package com.bookingmx.reservations;

/**
 * Interfaz que define el contrato para el servicio de gestión de reservaciones.
 * Abstrae la lógica de negocio de su implementación concreta.
 */
public interface IReservationService {
    Reservation createReservation(String guestName);
    Reservation getReservation(String id);
    Reservation editGuestName(String id, String newGuestName);
    void cancelReservation(String id);
}