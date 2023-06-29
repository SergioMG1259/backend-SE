package com.OpenCrew.ERentCar.shared.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String resourceName,  Long resourceId) {
        super(String.format("%s with id %d not found", resourceName, resourceId));
    }
    public ResourceNotFound(String resourceName) {
        super(String.format("%s not register"));
    }
}
