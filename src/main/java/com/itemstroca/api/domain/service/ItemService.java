package com.itemstroca.api.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.itemstroca.api.domain.model.Item;
import com.itemstroca.api.domain.repository.ItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Transactional
    public Item register(final Item item){
        return itemRepository.save(item);
    }
    @Transactional
    public List<Item> list(){
        return itemRepository.findAll();
    }
    
    @Transactional
    public List<Item> mainItem(final Long personId) {
        return itemRepository.findByPersonIdAndIsPrimary(personId, true);
    }

    public void removerItem(final Long itemId) {
        itemRepository.deleteById(itemId);
    }

}
