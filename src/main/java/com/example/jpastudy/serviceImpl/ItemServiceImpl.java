package com.example.jpastudy.serviceImpl;


import com.example.jpastudy.entity.ItemEntity;
import com.example.jpastudy.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long registItem(ItemEntity itemEntity) {
        em.persist(itemEntity);
        return itemEntity.getId();
    }

    @Override
    public ItemEntity findById(Long id) {
        return em.find(ItemEntity.class, id);
    }
}
