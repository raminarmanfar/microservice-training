package com.armanfar.microservice.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(int userId) {
        super("User ID: " + userId);
    }
}
