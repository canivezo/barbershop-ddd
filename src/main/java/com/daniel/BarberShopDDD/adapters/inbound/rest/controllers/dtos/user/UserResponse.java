package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user;

import java.time.LocalDate;

public class UserResponse {
    private Long id;
    private String fullName;
    private LocalDate birthdate;
    private String userName;
    private String userPassword;
    private String nationalRegistration;
    private UserAddressResponse userAddress;

    public UserResponse(Long id, String fullName, LocalDate birthdate, String userName, String userPassword, String nationalRegistration, UserAddressResponse userAddress) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.userName = userName;
        this.userPassword = userPassword;
        this.nationalRegistration = nationalRegistration;
        this.userAddress = userAddress;
    }

    public Long getId() {
        return id;
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

    public UserAddressResponse getUserAddress() {
        return userAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setNationalRegistration(String nationalRegistration) {
        this.nationalRegistration = nationalRegistration;
    }

    public void setUserAddress(UserAddressResponse userAddress) {
        this.userAddress = userAddress;
    }
}
