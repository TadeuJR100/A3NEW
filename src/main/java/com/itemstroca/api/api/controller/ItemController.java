package com.itemstroca.api.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.itemstroca.api.api.model.ItemInputDTO;
import com.itemstroca.api.api.model.ItemOutDTO;
import com.itemstroca.api.assembler.ItemAssembler;
import com.itemstroca.api.domain.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@AllArgsConstructor
@RequestMapping("/Item")
public class ItemController {
    private ItemAssembler itemAssembler;
    private ItemService itemService;
   
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemOutDTO postMethodName(@RequestBody final @Valid ItemInputDTO itemInputDTO) {  
        return itemAssembler.toDto(itemService.register(itemAssembler.toItem(itemInputDTO)));
    }
    
    @GetMapping("/list")
    public List<ItemOutDTO> list() {
        return itemAssembler.toCollectionDto(itemService.list());
    }
    
    @GetMapping("/{personId}")
    public List<ItemOutDTO> getMethodName(@PathVariable final @NotNull Long personId) {
        return itemAssembler.toCollectionDto(itemService.mainItem(personId));
    }
    
    @DeleteMapping("/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable final Long itemId){
       itemService.removerItem(itemId); 
    }
}
