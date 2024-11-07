package com.itemstroca.api.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itemstroca.api.api.model.AddressInputDTO;
import com.itemstroca.api.api.model.AddressOutDTO;
import com.itemstroca.api.api.model.PersonInputDTO;
import com.itemstroca.api.api.model.PersonOutDTO;
import com.itemstroca.api.assembler.AddressAssembler;
import com.itemstroca.api.domain.service.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private AddressAssembler addressAssembler;
    private AddressService addressService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressOutDTO getMethodName(@RequestBody final @Valid AddressInputDTO addressInputDTO) {
        return addressAssembler.toDto(addressService.register(addressAssembler.toAddress(addressInputDTO)));
    }

    @GetMapping("/list")
    public List<AddressOutDTO> list() {
        return addressAssembler.toCollectionDto(addressService.list());
    }

    @GetMapping("/{personId}")
    public List<AddressOutDTO> getMethodName(@PathVariable final @NotNull Long personId) {
        return addressAssembler.toCollectionDto(addressService.mainAddress(personId));
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable final Long addressId) {
        addressService.removerAddress(addressId);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<AddressOutDTO> update(@PathVariable final @NotNull Long personId,
            @RequestBody @Valid final AddressInputDTO addressInputDTO) {

        return ResponseEntity
                .ok(addressAssembler.toDto(addressService.update(addressAssembler.toAddress(addressInputDTO), personId)));
    }

}