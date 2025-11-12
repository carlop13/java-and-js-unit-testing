package com.bookingmx.reservations;

/**
 * Represents a single reservation entity (Model).
 * This class holds all data related to a reservation, including its ID, guest name,
 * and current status.
 */
public class Reservation {

    private String id;
    private String guestName;
    private Status status;

    /**
     * Enum representing the possible states of a reservation.
     */
    public enum Status { CONFIRMED, CANCELLED }

    /**
     * Constructs a new Reservation instance.
     * The initial status is always set to CONFIRMED.
     *
     * @param id The unique identifier for the reservation.
     * @param guestName The name of the guest.
     * @throws IllegalArgumentException if id or guestName are null or blank.
     */
    public Reservation(String id, String guestName) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Reservation ID cannot be empty.");
        }
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new IllegalArgumentException("Guest name cannot be empty.");
        }
        this.id = id;
        this.guestName = guestName;
        this.status = Status.CONFIRMED;
    }

    // --- Getters and Setters ---

    /** @return The unique ID of the reservation. */
    public String getId() { return id; }

    /** @return The name of the guest associated with the reservation. */
    public String getGuestName() { return guestName; }

    /**
     * Updates the name of the guest.
     * @param guestName The new name for the guest.
     */
    public void setGuestName(String guestName) { this.guestName = guestName; }

    /** @return The current status of the reservation (CONFIRMED or CANCELLED). */
    public Status getStatus() { return status; }

    /**
     * Updates the status of the reservation.
     * @param status The new status (CONFIRMED or CANCELLED).
     */
    public void setStatus(Status status) { this.status = status; }
}