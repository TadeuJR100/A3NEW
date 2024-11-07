package com.itemstroca.api.domain.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.itemstroca.api.domain.model.Person;
import com.itemstroca.api.domain.model.Users;
import com.itemstroca.api.domain.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Transactional
    public Users register(final Users users){
        return usersRepository.save(users);
    }
    @Transactional
    public List<Users> list(){
        return usersRepository.findAll();
    }
    
    @Transactional
    public List<Users> mainUsers(final Long personId) {
        return usersRepository.findByPersonIdAndIsPrimary(personId, true);
    }

     @Transactional
    public Users update(final Users users, Long usersId) {

        Users findUsers= search(usersId);
        findUsers.setUsername(users.getUsername());
        findUsers.setPassword(users.getPassword());

        return usersRepository.save(findUsers);
    }
    
    @Transactional
    public Users search(final Long usersId) {
        return usersRepository.findById(usersId).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public void removerUsers(final Long usersId) {
        usersRepository.deleteById(usersId);
    }
    
}