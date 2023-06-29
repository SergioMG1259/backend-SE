package com.OpenCrew.ERentCar.users.application.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.OpenCrew.ERentCar.shared.exception.BadRequestException;
import com.OpenCrew.ERentCar.shared.exception.ResourceNotFound;
import com.OpenCrew.ERentCar.users.application.commands.UserCreateCommand;
import com.OpenCrew.ERentCar.users.application.handlers.UserCreateCommandHandler;
import com.OpenCrew.ERentCar.users.application.requests.CreateUser;
import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.entities.UserRole;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;
import com.OpenCrew.ERentCar.users.domain.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserCreateCommandHandler userCreateCommandHandler;
    private final UserRepository userRepository;
    private final Validator validator;
    public UserServiceImpl(UserCreateCommandHandler userCreateCommandHandler,UserRepository userRepository, Validator validator) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userRepository=userRepository;
        this.validator = validator;
    }
    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id)
        .orElseThrow(()->new ResourceNotFound("USER",id));
    }
    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public User registerUser(CreateUser user) {

        Set<ConstraintViolation<CreateUser>>violations=validator.validate(user);
        if(!violations.isEmpty()){
            throw new BadRequestException("USER",violations);
        }
        UserRole userRole;
        try {
            userRole = UserRole.valueOf(user.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid role value");
        }
        UserCreateCommand userCreateCommand= new UserCreateCommand(
            user.getName(),user.getLastName(),user.getEmail(),user.getPassword(),
            user.getPhoto(),userRole);
        return this.userCreateCommandHandler.handle(userCreateCommand);
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    @Override
    public Page<User> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public User login(String email, String password) {
        // TODO Auto-generated method stub
        return this.userRepository.findByEmailAndPassword(email,password)
        .orElseThrow(()->new ResourceNotFound("USER"));
    }
}
