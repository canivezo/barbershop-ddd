package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers;

import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.CreateUserRequest;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserResponse;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.spec.UserControllerSpec;
import com.daniel.BarberShopDDD.application.services.UserService;
import com.daniel.BarberShopDDD.domain.entities.UserEntity;
import com.daniel.BarberShopDDD.shared.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerSpec {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        final UserEntity newUserEntity = userService.createUser(userMapper.toDomain(createUserRequest));
        return userMapper.toResponse(newUserEntity);
    }

    @Override
    public UserResponse getUser(Long userId) {
        return userMapper.toResponse(userService.findUserById(userId));
    }
}
