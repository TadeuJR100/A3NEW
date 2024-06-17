package com.itemstroca.api.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersInputDTO {
    private static final int SIZE_MIN_USER = 4; 
    private static final int SIZE_MAX_USER = 50;
    private static final int SIZE_MIN_PASS = 6; 
    private static final int SIZE_MAX_PASS = 100;
    @Valid
    @NotNull
    private PersonBaseDTO person;

    @NotBlank
    @Size(min = SIZE_MIN_USER, max = SIZE_MAX_USER)
    private String username;

    @NotBlank
    @Size(min = SIZE_MIN_PASS, max = SIZE_MAX_PASS)
    private String password;

    @NotNull
    @AssertTrue
    private Boolean isPrimary;
}
