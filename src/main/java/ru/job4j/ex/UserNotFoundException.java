package ru.job4j.ex;

public class UserNotFoundException extends UserInvalidException {
    public UserNotFoundException(String message) {
        super(message);
    }
}