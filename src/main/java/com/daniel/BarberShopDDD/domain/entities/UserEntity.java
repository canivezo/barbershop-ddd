package com.daniel.BarberShopDDD.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birthdate;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false, unique=true)
    @Pattern(regexp="\\d{11}", message = "Apenas informe 11 digitos.")
    private String nationalRegistration;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AddressEntity address;

    public UserEntity() {}

    public UserEntity(String fullName, LocalDate birthdate, String userName, String userPassword, String nationalRegistration, AddressEntity address) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.userName = userName;
        this.userPassword = userPassword;
        this.nationalRegistration = nationalRegistration;
        this.address = address;
    }

    public UserEntity(Long id, String fullName, LocalDate birthdate, String userName, String userPassword, String nationalRegistration, AddressEntity address) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.userName = userName;
        this.userPassword = userPassword;
        this.nationalRegistration = nationalRegistration;
        this.address = address;
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
