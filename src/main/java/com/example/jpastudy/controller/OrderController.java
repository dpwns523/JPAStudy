package com.example.jpastudy.controller;

import com.example.jpastudy.entity.OrderItemEntity;
import com.example.jpastudy.entity.OrdersEntity;
import com.example.jpastudy.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    /*
        엔티티 직접 노출
     */
    @GetMapping("api/orders")
    public List<OrdersEntity> orders(){
        List<OrdersEntity> all = orderRepository.findAll();
        for(OrdersEntity order : all){
            order.getMemberEntity().getName();  // Lazy 강제 초기화
            order.getDeliveryEntity().getCity();    // Lazy 강제 초기화
            List<OrderItemEntity> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o->o.getItem().getName());  // Lazy 강제 초기화
        }
        return all;
    }
}
