package com.OpenCrew.ERentCar.rents.application.handlers;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.rents.application.commands.RentUpdateCommand;
import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.rents.domain.repository.RentRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;

@Service
public class RentUpdateCommandHandler {
    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    public RentUpdateCommandHandler(RentRepository rentRepository, CarRepository carRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    public Rent handle(RentUpdateCommand command,Long id){
        Rent rent=rentRepository.findById(id)
            .orElseThrow(()->new ResourceNotFound("RENT",id));
        
        rent.setState(command.getState());
        Car car=this.carRepository.findById(rent.getReservation().getCar().getId()).orElseThrow(()->new ResourceNotFound("CAR",id));

        car.setState("FREE");
        carRepository.save(car);

        return rentRepository.save(rent);
    }
    
}
