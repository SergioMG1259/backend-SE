package com.OpenCrew.ERentCar.scores.application.handler;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.scores.application.commands.ScoreOwnerCreateCommand;
import com.OpenCrew.ERentCar.scores.domain.entities.ScoreOwner;
import com.OpenCrew.ERentCar.scores.domain.repository.ScoreOwnerRepository;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class ScoreOwnerCreateCommandHandler {
    private final ScoreOwnerRepository scoreOwnerRepository;
    private final UserRepository userRepository;
    public ScoreOwnerCreateCommandHandler(ScoreOwnerRepository scoreOwnerRepository, UserRepository userRepository) {
        this.scoreOwnerRepository = scoreOwnerRepository;
        this.userRepository = userRepository;
    }
    public ScoreOwner handle(ScoreOwnerCreateCommand command,Long ownerId,Long clientId){
        ScoreOwner scoreOwner=new ScoreOwner();
        scoreOwner.setComment(command.getComment());
        scoreOwner.setScore(command.getScore());
        User owner=this.userRepository.findById(ownerId).orElseThrow(()->new ResourceNotFound("USER",ownerId));
        User client=this.userRepository.findById(clientId).orElseThrow(()->new ResourceNotFound("USER",clientId));
        scoreOwner.setOwner(owner);
        scoreOwner.setClient(client);
        this.scoreOwnerRepository.save(scoreOwner);
        Double newScore=this.scoreOwnerRepository.getNewScoreOwner(ownerId);
        owner.setScore(newScore);
        this.userRepository.save(owner);

        return scoreOwner;
    }
}
