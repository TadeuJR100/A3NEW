package com.itemstroca.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.itemstroca.api.api.model.AddressInputDTO;
import com.itemstroca.api.api.model.AddressOutDTO;
import com.itemstroca.api.domain.model.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AddressAssembler {

    private ModelMapper modelMapper;

    public Address toAddress(final AddressInputDTO addressInputDTO) {
        return modelMapper.map(addressInputDTO, Address.class);
    }

    public AddressOutDTO toDto(final Address address) {
        return modelMapper.map(address, AddressOutDTO.class);
    }

    public List<AddressOutDTO> toCollectionDto(final List<Address> addresses) {
        return addresses.stream().map(this::toDto).collect(Collectors.toList());
    }

}