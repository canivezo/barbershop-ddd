package com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.spec;

import com.daniel.BarberShopDDD.adapters.inbound.rest.controllers.dtos.user.UserResponse;
import com.daniel.BarberShopDDD.domain.exceptions.UserDuplicatedException;
import com.daniel.BarberShopDDD.domain.exceptions.UserNotFoundException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@interface CreateUserResponses {

    ApiResponse[] value() default {
            @ApiResponse(
                    responseCode = "201",
                    description = "Create Users response",
                    content = @Content(
                            schema = @Schema(implementation = UserResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "CreateUserResponse",
                                            value = "Create user Example"
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "User duplicated",
                    content = @Content(
                            schema = @Schema(implementation = UserDuplicatedException.class),
                            examples = {
                                    @ExampleObject(
                                            name = "User duplicated",
                                            value = "bla"
                                    )
                            }
                    )
            )
    };
}

@interface FindUserResponses {

    ApiResponse[] value() default {
            @ApiResponse(
                    responseCode = "200",
                    description = "User response",
                    content = @Content(
                            schema = @Schema(implementation = UserResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "CreateUserResponse",
                                            value = "Create user Example"
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found",
                    content = @Content(
                            schema = @Schema(implementation = UserNotFoundException.class),
                            examples = {
                                    @ExampleObject(
                                            name = "User not found",
                                            value = "bla"
                                    )
                            }
                    )
            )
    };
}
