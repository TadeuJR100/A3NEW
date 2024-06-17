package com.itemstroca.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.itemstroca.api.api.model.PersonInputDTO;
import com.itemstroca.api.api.model.PersonOutDTO;
import com.itemstroca.api.domain.model.Person;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PersonAssembler {

    private ModelMapper modelMapper;

    public Person toPerson(final PersonInputDTO personInputDTO) {
        return modelMapper.map(personInputDTO, Person.class);
    }

    public PersonOutDTO toDto(final Person person) {
        return modelMapper.map(person, PersonOutDTO.class);
    }

    public List<PersonOutDTO> toCollectionDto(final List<Person> people) {
        return people.stream().map(this::toDto).collect(Collectors.toList());
    }

}
