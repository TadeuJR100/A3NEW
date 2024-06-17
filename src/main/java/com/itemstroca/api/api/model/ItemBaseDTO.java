package com.itemstroca.api.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemBaseDTO {
    @NotNull
    private Long id;
}
