package com.OpenCrew.ERentCar.users.application.handlers;

import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.users.application.commands.UserCreateCommand;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Service
public class UserCreateCommandHandler {
    private final UserRepository userRepository;

    public UserCreateCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User handle(UserCreateCommand command) {
        User user = new User();
        user.setName(command.getName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setPassword(command.getPassword());
        user.setPhoto(command.getPhoto());
        user.setRole(command.getRole());
        user.setScore(0.0);


        return userRepository.save(user);
    }
}