package com.OpenCrew.ERentCar.scores.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.scores.application.commands.ScoreOwnerCreateCommand;
import com.OpenCrew.ERentCar.scores.application.handler.ScoreOwnerCreateCommandHandler;
import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreOwnerService;

@Service
public class ScoreOwnerServiceImpl implements ScoreOwnerService{
    private final ScoreOwnerCreateCommandHandler scoreOwnerCreateCommandHandler;

    public ScoreOwnerServiceImpl(ScoreOwnerCreateCommandHandler scoreOwnerCreateCommandHandler) {
        this.scoreOwnerCreateCommandHandler = scoreOwnerCreateCommandHandler;
    }

    @Override
    public ScoreOwner getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ScoreOwner registerScoreOwner(CreateScore createScore,Long ownerId,Long clientId) {
        ScoreOwnerCreateCommand scoreOwnerCreateCommand=new ScoreOwnerCreateCommand(createScore.getComment(), createScore.getScore());
        return this.scoreOwnerCreateCommandHandler.handle(scoreOwnerCreateCommand, ownerId, clientId);
    }

    @Override
    public List<ScoreOwner> getByOwnerId(Long ownerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByOwnerId'");
    }

    
}
