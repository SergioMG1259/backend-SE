package com.OpenCrew.ERentCar.shared.exception;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

public class BadRequestException extends RuntimeException{
    public BadRequestException() { super(); }

    public BadRequestException(String message) { super(message); }

    public <T> BadRequestException(String resourceName, Set<ConstraintViolation<T>> violations) {
        super(String.format("Not all constraints satisfied for %s: %s", resourceName,
                violations.stream().map(violation -> String.format("%s %s", violation.getPropertyPath(), violation.getMessage()))
                        .collect(Collectors.joining(". "))));
    }

}