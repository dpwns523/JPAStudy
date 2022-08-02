package com.example.jpastudy.repository.order.simplequery;

import com.example.jpastudy.controller.OrderController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos(){
        return em.createQuery(
                "select new com.example.jpastudy.repository.order.simplequery.OrderSimpleQueryDto" +
                        "(o.id, m.name, o.orderDate, o.status,d.address)"+
                " from Orders o"+
                " join o.member m"+
                " join o.delivery d", OrderSimpleQueryDto.class).getResultList();
    }
}
