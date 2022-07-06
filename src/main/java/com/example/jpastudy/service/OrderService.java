package com.example.jpastudy.service;


import com.example.jpastudy.entity.OrdersEntity;

public interface OrderService {
    Long registOrder(OrdersEntity ordersEntity);
    OrdersEntity findById(Long id);
    void cancel(Long orderId);
}
