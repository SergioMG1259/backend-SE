package com.OpenCrew.ERentCar.scores.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.scores.application.commands.ScoreCarCreateCommand;
import com.OpenCrew.ERentCar.scores.application.handler.ScoreCarCreateCommandHandler;
import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreCar;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreCarService;

@Service
public class ScoreCarServiceImpl implements ScoreCarService{
    private final ScoreCarCreateCommandHandler scoreCarCreateCommandHandler;

    public ScoreCarServiceImpl(ScoreCarCreateCommandHandler scoreCarCreateCommandHandler) {
        this.scoreCarCreateCommandHandler = scoreCarCreateCommandHandler;
    }

    @Override
    public ScoreCar getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ScoreCar registerScoreCar(CreateScore createCar, Long carId, Long clientId,Long rentId) {

        ScoreCarCreateCommand scoreCarCreateCommand=new ScoreCarCreateCommand(createCar.getComment(),createCar.getScore());
        return this.scoreCarCreateCommandHandler.handle(scoreCarCreateCommand, carId, clientId,rentId);
    }

    @Override
    public List<ScoreCar> getByCarId(Long carId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCarId'");
    }
    

}
