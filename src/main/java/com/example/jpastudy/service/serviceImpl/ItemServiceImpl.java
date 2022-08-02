package com.example.jpastudy.service.serviceImpl;


import com.example.jpastudy.entity.item.Item;
import com.example.jpastudy.repository.ItemRepository;
import com.example.jpastudy.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Long registItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findOne(id);
    }
}
