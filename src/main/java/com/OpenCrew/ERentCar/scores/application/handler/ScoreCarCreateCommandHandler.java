package com.OpenCrew.ERentCar.scores.application.handler;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.cars.domain.entities.Car;
import com.OpenCrew.ERentCar.cars.domain.repository.CarRepository;
import com.OpenCrew.ERentCar.rents.domain.entities.Rent;
import com.OpenCrew.ERentCar.rents.domain.repository.RentRepository;
import com.OpenCrew.ERentCar.scores.application.commands.ScoreCarCreateCommand;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreCarRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class ScoreCarCreateCommandHandler {
    private final ScoreCarRepository scoreCarRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final RentRepository rentRepository;

    public ScoreCarCreateCommandHandler(ScoreCarRepository scoreCarRepository, UserRepository userRepository,
            CarRepository carRepository,RentRepository rentRepository) {
        this.scoreCarRepository = scoreCarRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.rentRepository=rentRepository;
    }
    public ScoreCar handle(ScoreCarCreateCommand command,Long carId,Long clientId,Long rentId){
        ScoreCar scoreCar=new ScoreCar();
        scoreCar.setComment(command.getComment());
        scoreCar.setScore(command.getScore());
        User client=this.userRepository.findById(clientId).orElseThrow(()->new ResourceNotFound("USER",clientId));
        Car car=this.carRepository.findById(carId).orElseThrow(()->new ResourceNotFound("CAR",carId));
        scoreCar.setClient(client);
        scoreCar.setCar(car);

        this.scoreCarRepository.save(scoreCar);

        Double newScore=this.scoreCarRepository.getNewScoreCar(carId);
        car.setScore(newScore);
        this.carRepository.save(car);

        Rent rent=rentRepository.findById(rentId)
            .orElseThrow(()->new ResourceNotFound("RENT",rentId));
        rent.setStateScore(true);
        this.rentRepository.save(rent);

        return scoreCar;
    }
}
