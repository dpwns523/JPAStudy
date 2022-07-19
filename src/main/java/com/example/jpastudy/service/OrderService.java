package com.example.jpastudy.service;


import com.example.jpastudy.entity.OrdersEntity;

public interface OrderService {
    // 주문
    Long Order(Long memberId, Long itemId, int count);
    OrdersEntity findById(Long id);
    void cancel(Long orderId);
}
