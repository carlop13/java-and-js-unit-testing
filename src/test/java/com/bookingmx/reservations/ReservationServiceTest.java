package com.bookingmx.reservations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    private IReservationService service;

    @BeforeEach
    void setUp() {
        // Antes de cada prueba, creamos una nueva instancia del servicio.
        service = new ReservationService();
    }

    // --- Pruebas para createReservation() ---

    @Test
    @DisplayName("Should create a reservation successfully with a valid guest name")
    void testCreateReservation_Success() {
        // Arrange (preparación)
        String guestName = "Carlos López";

        // Act (ejecución)
        Reservation newReservation = service.createReservation(guestName);

        // Assert (verificación)
        assertNotNull(newReservation, "The created reservation should not be null.");
        assertNotNull(newReservation.getId(), "Reservation should have a non-null ID.");
        assertEquals(guestName, newReservation.getGuestName(), "Guest name should match the one provided.");
        assertEquals(Reservation.Status.CONFIRMED, newReservation.getStatus(), "A new reservation should have CONFIRMED status.");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for a null guest name")
    void testCreateReservation_NullName_ThrowsException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.createReservation(null);
        });

        assertEquals("Guest name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for an empty guest name")
    void testCreateReservation_EmptyName_ThrowsException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.createReservation("   ");
        });

        assertEquals("Guest name cannot be empty.", exception.getMessage());
    }


    // --- Pruebas para cancelReservation() ---

    @Test
    @DisplayName("Should cancel an existing reservation successfully")
    void testCancelReservation_Success() {
        // Arrange
        Reservation reservation = service.createReservation("Test Guest");

        // Act & Assert: Verificamos que no se lanza una excepción
        assertDoesNotThrow(() -> service.cancelReservation(reservation.getId()));

        // Assert: Verificamos que el estado ha cambiado
        Reservation updatedReservation = service.getReservation(reservation.getId());
        assertEquals(Reservation.Status.CANCELLED, updatedReservation.getStatus(), "Reservation status should be CANCELLED.");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when canceling a non-existent reservation")
    void testCancelReservation_NotFound_ThrowsException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.cancelReservation("non-existent-id");
        });

        assertEquals("Reservation with ID non-existent-id not found.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalStateException when canceling an already cancelled reservation")
    void testCancelReservation_AlreadyCancelled_ThrowsException() {
        // Arrange
        Reservation reservation = service.createReservation("Test Guest");
        service.cancelReservation(reservation.getId()); // La cancelamos una vez

        // Act & Assert: Verificamos que al intentar cancelar de nuevo, se lanza la excepción
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            service.cancelReservation(reservation.getId());
        });

        assertEquals("Reservation is already cancelled.", exception.getMessage());
    }


    // --- Pruebas para editGuestName() ---

    @Test
    @DisplayName("Should edit guest name for an existing reservation")
    void testEditGuestName_Success() {
        // Arrange
        Reservation reservation = service.createReservation("Original Name");
        String newName = "Updated Name";

        // Act
        service.editGuestName(reservation.getId(), newName);

        // Assert
        Reservation updatedReservation = service.getReservation(reservation.getId());
        assertEquals(newName, updatedReservation.getGuestName(), "Guest name should be updated.");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when editing a non-existent reservation")
    void testEditGuestName_NotFound_ThrowsException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.editGuestName("non-existent-id", "New Name");
        });

        assertEquals("Reservation with ID non-existent-id not found.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for an empty new guest name")
    void testEditGuestName_EmptyNewName_ThrowsException() {
        // Arrange
        Reservation reservation = service.createReservation("Original Name");

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.editGuestName(reservation.getId(), "   ");
        });

        assertEquals("New guest name cannot be empty.", exception.getMessage());
    }
}