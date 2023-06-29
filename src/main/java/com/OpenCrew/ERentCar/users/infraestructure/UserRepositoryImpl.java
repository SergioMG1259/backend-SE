package com.OpenCrew.ERentCar.users.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OpenCrew.ERentCar.users.domain.entities.User;
import com.OpenCrew.ERentCar.users.domain.repository.UserRepository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User,Long>,UserRepository{
    
}
