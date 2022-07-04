package com.example.jpastudy.serviceImpl;

import com.example.jpastudy.entity.OrdersEntity;
import com.example.jpastudy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService {

    @PersistenceContext
    EntityManager em;

    @Override
    public Long registOrder(OrdersEntity ordersEntity) {
        em.persist(ordersEntity);
        return ordersEntity.getId();
    }

    @Override
    public OrdersEntity findById(Long id) {
        return em.find(OrdersEntity.class, id);
    }

    // 주문취소
    @Override
    @Transactional
    public void cancel(Long orderId) {
        OrdersEntity ordersEntity = findById(orderId);
        ordersEntity.cancel();
    }
}
