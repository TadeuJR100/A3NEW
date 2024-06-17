package com.itemstroca.api.domain.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.itemstroca.api.domain.model.Item;

public interface ItemRepository extends JpaRepository<Item , Long> {
    List<Item> findByPersonIdAndIsPrimary(Long personId, Boolean isPrimary);
}
