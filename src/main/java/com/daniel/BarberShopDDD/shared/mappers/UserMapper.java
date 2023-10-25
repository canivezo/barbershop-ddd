package com.daniel.BarberShopDDD.shared.mappers;

import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.CreateUserRequest;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserResponse;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserAddressRequest;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserAddressResponse;
import com.daniel.BarberShopDDD.domain.entities.AddressEntity;
import com.daniel.BarberShopDDD.domain.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toDomain(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity(
                request.getFullName(),
                request.getBirthdate(),
                request.getUserName(),
                request.getUserPassword(),
                request.getNationalRegistration(),
                toDomain(request.getUserAddress())
        );
        userEntity.getAddress().setUser(userEntity);
        return userEntity;
    }

    public AddressEntity toDomain(UserAddressRequest userAddressRequest) {
        return new AddressEntity(
                userAddressRequest.getStreet(),
                userAddressRequest.getNumber(),
                userAddressRequest.getNeighborhood(),
                userAddressRequest.getCity(),
                userAddressRequest.getState(),
                userAddressRequest.getZipCode(),
                userAddressRequest.getComplement(),
                null
        );
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getFullName(),
                userEntity.getBirthdate(),
                userEntity.getUserName(),
                userEntity.getUserPassword(),
                userEntity.getNationalRegistration(),
                toResponse(userEntity.getAddress())
        );
    }

    public UserAddressResponse toResponse(AddressEntity addressEntity) {
        return new UserAddressResponse(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getNeighborhood(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getZipCode(),
                addressEntity.getComplement()
        );
    }
}
