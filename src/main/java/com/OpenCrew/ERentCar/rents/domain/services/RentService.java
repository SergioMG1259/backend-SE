package com.OpenCrew.ERentCar.rents.domain.services;

import java.util.List;

import com.OpenCrew.ERentCar.rents.domain.entities.Rent;

public interface RentService {
    Rent getById(Long id);
    Rent registerRent(Long id);
    List<Rent> getByClientId(Long clientId);
    List<Rent> getByOwnerId(Long ownerId);
    Rent endRent(Long id);
}
