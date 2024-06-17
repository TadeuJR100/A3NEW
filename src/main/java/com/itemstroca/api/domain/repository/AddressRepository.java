package com.itemstroca.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemstroca.api.domain.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPersonIdAndIsPrimary(Long personId, Boolean isPrimary);
}
