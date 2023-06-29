package com.OpenCrew.ERentCar.cars.application.handlers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.application.commands.CarCreateCommand;
import com.OpenCrew.ERentCar.cars.application.mapper.LocationMapper;
import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.entities.Location;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.users.domain.entities.User;

@Service
public class CarCreateCommandHandler {
    private final CarRepository carRepository;
    private final LocationMapper mapper;

    public CarCreateCommandHandler(CarRepository carRepository,LocationMapper mapper) {
        this.carRepository = carRepository;
        this.mapper=mapper;
    }
    
    public Car handle(CarCreateCommand command,User user){
        Car car= new Car();
        car.setBrand(command.getBrand());
        car.setModel(command.getModel());
        car.setYear(command.getYear());
        car.setType(command.getType());
        car.setSeats(command.getSeats());
        car.setPlateNumber(command.getPlateNumber());
        car.setMileage(command.getMileage());
        car.setFuel(command.getFuel());
        car.setGearBox(command.getGearBox());
        car.setDescription(command.getDescription());
        car.setPricePerDay(command.getPricePerDay());
        car.setImage(command.getImage());
        car.setState("FREE");
        car.setUser(user);
        car.setScore(0.0);

        List<Location>locations=mapper.ListDTOListToModel(command.getLocations());
        locations.forEach(location->location.setCar(car));

        car.setLocations(locations);


        return this.carRepository.save(car);
    }
}
