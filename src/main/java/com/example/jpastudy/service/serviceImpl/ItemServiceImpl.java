package com.example.jpastudy.service.serviceImpl;


import com.example.jpastudy.entity.item.ItemEntity;
import com.example.jpastudy.repository.ItemRepository;
import com.example.jpastudy.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Long registItem(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
        return itemEntity.getId();
    }

    @Override
    public ItemEntity findById(Long id) {
        return itemRepository.findOne(id);
    }
}
