package com.OpenCrew.ERentCar.users.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserShortDTO {
    private Long id;

    private String name;

    private String lastName;

    private String photo;

    private Double score;

}
