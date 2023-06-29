package com.OpenCrew.ERentCar.rents.domain.services;

import java.util.List;

import com.OpenCrew.ERentCar.rents.application.requests.CreateReservation;
import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;

public interface ReservationService {
    Reservation getById(Long id);
    Reservation registerReservation(CreateReservation reservation,Long ownerId,Long carId,Long clientId);
    void deleteById(Long id);
    List<Reservation> getByClientId(Long clientId);
    List<Reservation> getByOwnerId(Long ownerId);
    Reservation acceptReservation(Long reservationId);
    Reservation declineReservation(Long reservationId);
}