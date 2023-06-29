package com.OpenCrew.ERentCar.scores.application.handler;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.scores.application.commands.ScoreClientCreateCommand;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreClient;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreClientRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class ScoreClientCreateCommandHandler {
    private final ScoreClientRepository scoreClientRepository;
    private final UserRepository userRepository;
    public ScoreClientCreateCommandHandler(ScoreClientRepository scoreClientRepository, UserRepository userRepository) {
        this.scoreClientRepository = scoreClientRepository;
        this.userRepository = userRepository;
    }
    public ScoreClient handle(ScoreClientCreateCommand command,Long clientId,Long ownerId){
        ScoreClient scoreClient=new ScoreClient();
        scoreClient.setComment(command.getComment());
        scoreClient.setScore(command.getScore());
        User owner=this.userRepository.findById(ownerId).orElseThrow(()->new ResourceNotFound("USER",ownerId));
        User client=this.userRepository.findById(clientId).orElseThrow(()->new ResourceNotFound("USER",clientId));
        scoreClient.setOwner(owner);
        scoreClient.setClient(client);
        this.scoreClientRepository.save(scoreClient);

        Double newScore=this.scoreClientRepository.getNewScoreClient(clientId);
        client.setScore(newScore);
        this.userRepository.save(client);

        return scoreClient;
    }
}
