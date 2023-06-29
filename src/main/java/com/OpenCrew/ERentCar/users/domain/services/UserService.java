package com.OpenCrew.ERentCar.users.domain.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.OpenCrew.ERentCar.users.application.requests.CreateUser;
import com.OpenCrew.ERentCar.users.domain.entities.User;

public interface UserService {
    User getById(Long id);
    /*User getByEmail(String email);*/
    List<User> getAll();
    User registerUser(CreateUser user);
    User login(String email, String password);
    void deleteById(Long id);
    Page<User> getAll(Pageable pageable);
}
