package com.itemstroca.api.domain.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.itemstroca.api.domain.model.Users;
import com.itemstroca.api.domain.repository.UsersRepository;
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

    public void removerUsers(final Long usersId) {
        usersRepository.deleteById(usersId);
    }

}