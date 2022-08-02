package com.example.jpastudy.repository.order.simplequery;

import com.example.jpastudy.entity.Address;
import com.example.jpastudy.enums.OrderStatus;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class OrderSimpleQueryDto {

    private Long orderId;
    private String name;
    private Timestamp orderDate; //주문시간
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(Long orderId, String name, Date orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = new Timestamp(orderDate.getTime());
        this.orderStatus = orderStatus;
        this.address = address;
    }
}

