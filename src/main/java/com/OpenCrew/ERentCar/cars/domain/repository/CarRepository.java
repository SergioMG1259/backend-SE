package com.OpenCrew.ERentCar.cars.domain.repository;

import java.util.List;
import java.util.Optional;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;

public interface CarRepository {
    Optional<Car> findById(Long id);
    List<Car> findAll();
    Car save(Car user);
    void deleteById(Long id);
    List<Car> findAllCarsByUserId(Long id);
    List<Car> findAllCarsByState(String state);
}
