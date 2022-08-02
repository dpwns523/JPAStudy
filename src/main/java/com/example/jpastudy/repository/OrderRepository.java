package com.example.jpastudy.repository;

import com.example.jpastudy.entity.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Orders orders) {
        em.persist(orders);
    }

    public Orders findOne(Long id) {
        return em.find(Orders.class, id);
    }

    public List<Orders> findAll() {
        return em.createQuery("select o from Orders o", Orders.class)
                .getResultList();
    }
    public List<Orders> findAllWithMemberDelivery(){
        return em.createQuery(
                "select o from Orders o"+
                        " join fetch o.member m"+
                        " join fetch o.delivery d", Orders.class)
                .getResultList();
    }

}