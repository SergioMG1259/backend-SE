package com.OpenCrew.ERentCar.cars.domain.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.requests.CreateCar;
import com.OpenCrew.ERentCar.cars.domain.entities.Car;

public interface CarService {
    Car getById(Long id);
    List<Car> getAll();
    Car registerCar(CreateCar car,Long ownerId);
    void deleteById(Long id);
    List<CarDTO> getAll(Pageable pageable,Long userId);
    List<Car> getByUserId(Long ownerId);
}