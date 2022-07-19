package com.example.jpastudy.repository;

import com.example.jpastudy.entity.OrdersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(OrdersEntity ordersEntity) {
        em.persist(ordersEntity);
    }

    public OrdersEntity findOne(Long id) {
        return em.find(OrdersEntity.class, id);
    }

    public List<OrdersEntity> findAll() {
        return em.createQuery("select o from OrdersEntity o", OrdersEntity.class)
                .getResultList();
    }

}