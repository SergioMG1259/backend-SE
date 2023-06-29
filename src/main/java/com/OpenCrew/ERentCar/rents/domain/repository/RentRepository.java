package com.OpenCrew.ERentCar.rents.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.rents.domain.entities.Rent;

public interface RentRepository {
    Optional<Rent> findById(Long id);
    Rent save(Rent rent);
    void deleteById(Long id);
    List<Rent> findAllRentsByOwnerId(Long id);
    List<Rent> findAllRentsByClientId(Long id);
}
