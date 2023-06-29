package com.OpenCrew.ERentCar.cars.application.dto;

import com.OpenCrew.ERentCar.users.application.dto.UserShortDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private Long id;

    private String brand;

    private String model;

    private String type;

    private int seats;

    private int year;

    private Double mileage;

    private Double pricePerDay;

    private String image;

    private Double score;

    private String state;

    private UserShortDTO user;
}
