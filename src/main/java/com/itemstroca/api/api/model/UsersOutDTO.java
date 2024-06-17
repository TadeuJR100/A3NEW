package com.itemstroca.api.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersOutDTO extends UsersBaseDTO {

    private String username;
    private String password;
    
}
