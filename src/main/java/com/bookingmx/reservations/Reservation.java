package com.bookingmx.reservations;

public class Reservation {
    private String id;
    private String guestName;
    private Status status;

    public enum Status { CONFIRMED, CANCELLED }

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

    public String getId() { return id; }
    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; } // Necesario para la prueba de edición
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}