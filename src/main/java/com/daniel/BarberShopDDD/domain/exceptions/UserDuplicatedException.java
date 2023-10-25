package com.daniel.BarberShopDDD.domain.exceptions;

public class UserDuplicatedException extends RuntimeException {
    public UserDuplicatedException(String message) {
        super(message);
    }
}
