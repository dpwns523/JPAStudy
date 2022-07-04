package com.example.jpastudy.domain;

import com.example.jpastudy.entity.OrderItemEntity;
import com.example.jpastudy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders {
    private Member member;

    @CreationTimestamp
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
}
