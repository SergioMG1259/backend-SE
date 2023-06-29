package com.OpenCrew.ERentCar.users.application.mapper;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.OpenCrew.ERentCar.shared.mapping.EnhancedModelMapper;
import com.OpenCrew.ERentCar.users.application.dto.UserDTO;
import com.OpenCrew.ERentCar.users.application.dto.LoginDTO;
import com.OpenCrew.ERentCar.users.domain.entities.User;

public class UserMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public UserDTO toDTO(User model){return mapper.map(model, UserDTO.class);}
    public LoginDTO toLogin(User model){return mapper.map(model,LoginDTO.class);}
}
