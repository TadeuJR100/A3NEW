package com.itemstroca.api.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.itemstroca.api.api.model.PersonInputDTO;
import com.itemstroca.api.api.model.PersonOutDTO;
import com.itemstroca.api.api.model.UsersInputDTO;
import com.itemstroca.api.api.model.UsersOutDTO;
import com.itemstroca.api.assembler.UsersAssembler;
import com.itemstroca.api.domain.service.UsersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@AllArgsConstructor
@RequestMapping("/Users")
public class UsersController {
    private UsersAssembler usersAssembler;
    private UsersService usersService;
   
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersOutDTO postMethodName(@RequestBody final @Valid UsersInputDTO usersInputDTO) {  
        return usersAssembler.toDto(usersService.register(usersAssembler.toUser(usersInputDTO)));
    }
    
    @GetMapping("/list")
    public List<UsersOutDTO> list() {
        return usersAssembler.toCollectionDto(usersService.list());
    }
    
    @GetMapping("/{personId}")
    public List<UsersOutDTO> getMethodName(@PathVariable final @NotNull Long personId) {
        return usersAssembler.toCollectionDto(usersService.mainUsers(personId));
    }
    
    @PutMapping("/{personId}")
    public ResponseEntity<UsersOutDTO> update(@PathVariable final @NotNull Long personId,
            @RequestBody @Valid final UsersInputDTO usersInputDTO) {

        return ResponseEntity
                .ok(usersAssembler.toDto(usersService.update(usersAssembler.toUser(usersInputDTO), personId)));
    }
    
    @DeleteMapping("/{usersId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable final Long usersId){
        usersService.removerUsers(usersId); 
    }
}