package com.itemstroca.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.itemstroca.api.api.model.ItemInputDTO;
import com.itemstroca.api.api.model.ItemOutDTO;
import com.itemstroca.api.domain.model.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ItemAssembler {
    private ModelMapper modelMapper;

    public Item toItem(final ItemInputDTO itemInputDTO){
        return modelMapper.map(itemInputDTO, Item.class);
    }
    public ItemOutDTO toDto(final Item item){
        return modelMapper.map(item, ItemOutDTO.class);
    }
    public List<ItemOutDTO> toCollectionDto(final List<Item> item) {
        return item.stream().map(this::toDto).collect(Collectors.toList());
    }
}
