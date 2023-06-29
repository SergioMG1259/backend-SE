package com.OpenCrew.ERentCar.users.application.dto;

import com.OpenCrew.ERentCar.users.domain.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private Long id;

    private UserRole role;
}
