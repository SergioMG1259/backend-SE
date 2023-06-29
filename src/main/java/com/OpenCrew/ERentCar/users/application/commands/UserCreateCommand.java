package com.OpenCrew.ERentCar.users.application.commands;

import com.OpenCrew.ERentCar.users.domain.entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateCommand {
    private String name;

    private String lastName;

    private String email;

    private String password;

    private String photo;

    private UserRole role;
    
}
