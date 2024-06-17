package com.itemstroca.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itemstroca.api.domain.model.Person;
import com.itemstroca.api.domain.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PersonService {

    private PersonRepository personRepository;

    @Transactional
    public Person register(final Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person update(final Person person, Long personId) {

        Person findPerson = search(personId);
        findPerson.setName(person.getName());
        findPerson.setDateBirth(person.getDateBirth());

        return personRepository.save(findPerson);
    }

    @Transactional
    public Person search(final Long personId) {
        return personRepository.findById(personId).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    @Transactional
    public List<Person> list() {
        return personRepository.findAll();
    }

}
