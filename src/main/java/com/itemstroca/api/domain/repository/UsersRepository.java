package com.itemstroca.api.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itemstroca.api.domain.model.Users;

public interface UsersRepository extends JpaRepository<Users , Long> {
    List<Users> findByPersonIdAndIsPrimary(Long personId, Boolean isPrimary);
}

