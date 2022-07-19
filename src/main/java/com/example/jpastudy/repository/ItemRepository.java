package com.example.jpastudy.repository;

import com.example.jpastudy.entity.item.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;


@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(ItemEntity itemEntity) {
        if (itemEntity.getId() == null) {
            em.persist(itemEntity);
        } else {
            em.merge(itemEntity);
        }
    }

    public ItemEntity findOne(Long id) {
        return em.find(ItemEntity.class, id);
    }


}
