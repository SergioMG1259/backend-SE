package com.OpenCrew.ERentCar.cars.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarShortDTO {
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
}
