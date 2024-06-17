package com.itemstroca.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.itemstroca.api.api.model.UsersInputDTO;
import com.itemstroca.api.api.model.UsersOutDTO;
import com.itemstroca.api.domain.model.Users;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsersAssembler {
        private ModelMapper modelMapper;

    public Users toUser(final UsersInputDTO usersInputDTO){
        return modelMapper.map(usersInputDTO, Users.class);
    }
    public UsersOutDTO toDto(final Users users){
        return modelMapper.map(users, UsersOutDTO.class);
    }
    public List<UsersOutDTO> toCollectionDto(final List<Users> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }
}