package com.example.jpastudy.service;



import com.example.jpastudy.entity.item.Item;

public interface ItemService {
    Long registItem(Item item);
    Item findById(Long id);
}
