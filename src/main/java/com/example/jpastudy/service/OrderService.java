package com.example.jpastudy.service;


import com.example.jpastudy.entity.Orders;

public interface OrderService {
    // 주문
    Long Order(Long memberId, Long itemId, int count);
    Orders findById(Long id);
    void cancel(Long orderId);
}
