package com.itemstroca.api.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutDTO extends ItemBaseDTO {
    private String name;
    private String valor;
}
