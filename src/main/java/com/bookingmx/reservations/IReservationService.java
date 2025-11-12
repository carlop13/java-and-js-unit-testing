package com.bookingmx.reservations;

/**
 * Defines the contract for the reservation management service.
 * This interface abstracts the business logic from its concrete implementation,
 * promoting decoupling and making the system easier to test and maintain.
 */
public interface IReservationService {

    /**
     * Creates a new reservation for a given guest.
     *
     * @param guestName The name of the guest for whom the reservation is made. Must not be null or blank.
     * @return The newly created Reservation object with a unique ID and CONFIRMED status.
     * @throws IllegalArgumentException if the guestName is null or blank.
     */
    Reservation createReservation(String guestName);

    /**
     * Retrieves an existing reservation by its unique ID.
     *
     * @param id The unique identifier of the reservation.
     * @return The Reservation object if found, otherwise null.
     */
    Reservation getReservation(String id);

    /**
     * Edits the guest name of an existing reservation.
     *
     * @param id The ID of the reservation to edit.
     * @param newGuestName The new name for the guest. Must not be null or blank.
     * @return The updated Reservation object.
     * @throws IllegalArgumentException if the reservation is not found or if the new guest name is invalid.
     */
    Reservation editGuestName(String id, String newGuestName);

    /**
     * Cancels an existing reservation by changing its status to CANCELLED.
     *
     * @param id The ID of the reservation to cancel.
     * @throws IllegalArgumentException if the reservation is not found.
     * @throws IllegalStateException if the reservation is already in the CANCELLED state.
     */
    void cancelReservation(String id);
}