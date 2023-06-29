package com.OpenCrew.ERentCar.cars.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;

@Repository
public interface CarRepositoryImpl extends JpaRepository<Car,Long>,CarRepository{
    
}
