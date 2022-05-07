package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="orders")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="order_id"))
public class OrdersEntity extends BaseEntity {

    @Column(name="member_id")   // 생략가능
    private Long memberId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
