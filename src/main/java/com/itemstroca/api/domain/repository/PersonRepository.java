package com.itemstroca.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemstroca.api.domain.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

