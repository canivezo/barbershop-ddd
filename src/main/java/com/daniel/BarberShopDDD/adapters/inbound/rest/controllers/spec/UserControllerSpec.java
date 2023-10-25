package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.spec;

import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.CreateUserRequest;
import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/user")
public interface UserControllerSpec {

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Creates a new User entity")
    @CreateUserResponses
    UserResponse createUser(@RequestBody CreateUserRequest createUserRequest);

    @GetMapping("/{userId}")
    @ResponseStatus(OK)
    @Operation(summary = "Finds an User entity")
    @FindUserResponses
    UserResponse getUser(@PathVariable Long userId);
}
