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
public class ItemInputDTO {
    private static final int SIZE_MIN_NAME = 4; 
    private static final int SIZE_MAX_NAME = 255;

    @Valid
    @NotNull
    private PersonBaseDTO person;

    @NotBlank
    @Size(min = SIZE_MIN_NAME, max = SIZE_MAX_NAME)
    private String name;

    @NotNull
    @AssertTrue
    private Boolean isPrimary;
     
}
