package com.OpenCrew.ERentCar.scores.application.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScore {
    private String comment;
    private Double score;
}
