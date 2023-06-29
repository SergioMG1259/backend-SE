package com.OpenCrew.ERentCar.users.application.dto;

import java.util.List;

import com.OpenCrew.ERentCar.cars.application.dto.CarDTO;
import com.OpenCrew.ERentCar.users.domain.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String photo;

    private Double score;

    private UserRole role;

    /*private List<CarDTO> cars;*/
}