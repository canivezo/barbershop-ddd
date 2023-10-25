package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user;

import java.time.LocalDate;

public class CreateUserRequest {
    private final String fullName;
    private final LocalDate birthdate;
    private final String userName;
    private final String userPassword;
    private final String nationalRegistration;
    private final UserAddressRequest userAddress;

    public CreateUserRequest(String fullName, LocalDate birthdate, String userName, String userPassword, String nationalRegistration, UserAddressRequest userAddress) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.userName = userName;
        this.userPassword = userPassword;
        this.nationalRegistration = nationalRegistration;
        this.userAddress = userAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getNationalRegistration() {
        return nationalRegistration;
    }

    public UserAddressRequest getUserAddress() {
        return userAddress;
    }
}
