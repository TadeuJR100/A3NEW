package com.itemstroca.api.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itemstroca.api.api.model.PersonInputDTO;
import com.itemstroca.api.api.model.PersonOutDTO;
import com.itemstroca.api.assembler.PersonAssembler;
import com.itemstroca.api.domain.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private PersonAssembler personAssembler;
    private PersonService personService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonOutDTO getMethodName(@RequestBody final @Valid PersonInputDTO personInputDTO) {
        return personAssembler.toDto(personService.register(personAssembler.toPerson(personInputDTO)));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonOutDTO> update(@PathVariable final @NotNull Long personId,
            @RequestBody @Valid final PersonInputDTO personInputDTO) {

        return ResponseEntity
                .ok(personAssembler.toDto(personService.update(personAssembler.toPerson(personInputDTO), personId)));
    }

    @GetMapping("/{personId}")
    public PersonOutDTO consult(@PathVariable final @NotNull Long personId) {

        return personAssembler.toDto(personService.search(personId));

    }

    @GetMapping("/list")
    public List<PersonOutDTO> list() {
        return personAssembler.toCollectionDto(personService.list());
    }
}
