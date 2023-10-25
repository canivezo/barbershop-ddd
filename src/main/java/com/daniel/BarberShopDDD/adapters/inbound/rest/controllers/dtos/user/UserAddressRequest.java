package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user;

public class UserAddressRequest {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String complement;

    public UserAddressRequest(String street, String number, String neighborhood, String city, String state, String zipCode, String complement) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getComplement() {
        return complement;
    }
}
