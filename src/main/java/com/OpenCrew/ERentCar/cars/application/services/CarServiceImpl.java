package com.OpenCrew.ERentCar.cars.application.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.application.commands.CarCreateCommand;
import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.cars.application.handlers.CarCreateCommandHandler;
import com.OpenCrew.ERentCar.cars.application.requests.CreateCar;
import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.cars.domain.services.CarService;
import com.OpenCrew.ERentCar.shared.exception.BadRequestException;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class CarServiceImpl implements CarService{
    private final CarCreateCommandHandler carCreateCommandHandler;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final Validator validator;
    
    public CarServiceImpl(CarCreateCommandHandler carCreateCommandHandler,CarRepository carRepository ,UserRepository userRepository,Validator validator) {
        this.carCreateCommandHandler = carCreateCommandHandler;
        this.userRepository=userRepository;
        this.carRepository=carRepository;
        this.validator = validator;
    }

    @Override
    public Car getById(Long id) {
        // TODO Auto-generated method stub
        return this.carRepository.findById(id)
        .orElseThrow(()->new ResourceNotFound("CAR",id));
    }

    @Override
    public List<Car> getAll() {
        // TODO Auto-generated method stub
        return this.carRepository.findAllCarsByState("FREE");
    }

    @Override
    public Car registerCar(CreateCar car, Long ownerId) {
        // TODO Auto-generated method stub
        Set<ConstraintViolation<CreateCar>>violations=validator.validate(car);
        if(!violations.isEmpty()){
            throw new BadRequestException("CAR",violations);
        }
        User user=this.userRepository.findById(ownerId).orElseThrow(()->new ResourceNotFound("USER",ownerId));

        CarCreateCommand carCreateCommand= new CarCreateCommand(
            car.getBrand(),car.getModel(),car.getType(),car.getSeats(),car.getYear(),car.getFuel(),
            car.getGearBox(),car.getPlateNumber(),car.getDescription(),car.getMileage(),car.getPricePerDay(),car.getImage(),
            car.getLocations()
        );

        return this.carCreateCommandHandler.handle(carCreateCommand, user);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<CarDTO> getAll(Pageable pageable, Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Car> getByUserId(Long ownerId) {
         return this.carRepository.findAllCarsByUserId(ownerId);
    }
}
