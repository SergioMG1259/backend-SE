package com.OpenCrew.ERentCar.scores.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.scores.application.commands.ScoreClientCreateCommand;
import com.OpenCrew.ERentCar.scores.application.handler.ScoreClientCreateCommandHandler;
import com.OpenCrew.ERentCar.scores.application.requests.CreateScore;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;
import com.OpenCrew.ERentCar.scores.domain.services.ScoreClientService;

@Service
public class ScoreClientServiceImpl implements ScoreClientService{
    private final ScoreClientCreateCommandHandler scoreClientCreateCommandHandler;

    public ScoreClientServiceImpl(ScoreClientCreateCommandHandler scoreClientCreateCommandHandler) {
        this.scoreClientCreateCommandHandler = scoreClientCreateCommandHandler;
    }

    @Override
    public ScoreClient getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ScoreClient registerScoreClient(CreateScore createScore, Long clientId, Long ownerId) {
        ScoreClientCreateCommand scoreClientCreateCommand=new ScoreClientCreateCommand(createScore.getComment(), createScore.getScore());
        return this.scoreClientCreateCommandHandler.handle(scoreClientCreateCommand, clientId, ownerId);
    }

    @Override
    public List<ScoreClient> getByClientId(Long clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByClientId'");
    }
}
