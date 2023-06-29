package com.OpenCrew.ERentCar.rents.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.rents.domain.entities.Reservation;

public interface ReservationRepository {
    Optional<Reservation> findById(Long id);
    Reservation save(Reservation reservation);
    void deleteById(Long id);
    List<Reservation> findAllReservationsByOwnerId(Long id);
    List<Reservation> findAllReservationsByClientId(Long id);
}