package com.itemstroca.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itemstroca.api.domain.model.Address;
import com.itemstroca.api.domain.model.Users;
import com.itemstroca.api.domain.repository.AddressRepository;

import jakarta.persistence.EntityNotFoundException;
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

     @Transactional
    public Address update(final Address address, Long addressId) {

        Address findAddress = search(addressId);
        findAddress.setStreet(address.getStreet());
        findAddress.setZipCode(address.getZipCode());
        findAddress.setNumber(address.getNumber());
        findAddress.setCity(address.getCity());

        return addressRepository.save(findAddress);
    }

    public void removerAddress(final Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Transactional
    public Address search(final Long addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("cep not found"));
    }

}
