package com.example.jpastudy.service;



import com.example.jpastudy.entity.ItemEntity;

public interface ItemService {
    Long registItem(ItemEntity itemEntity);
    ItemEntity findById(Long id);
}
