package com.itemstroca.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itemstroca.api.domain.model.Address;
import com.itemstroca.api.domain.repository.AddressRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public Address register(final Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public List<Address> list() {
        return addressRepository.findAll();
    }

    @Transactional
    public List<Address> mainAddress(final Long personId) {
        return addressRepository.findByPersonIdAndIsPrimary(personId, true);
    }

    public void removerAddress(final Long addressId) {
        addressRepository.deleteById(addressId);
    }

}
