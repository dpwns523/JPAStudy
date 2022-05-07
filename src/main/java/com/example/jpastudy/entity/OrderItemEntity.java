package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_item")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="order_item_id"))
public class OrderItemEntity extends BaseEntity {

    private Long itemId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생
    private Long orderId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생

    private Integer orderPrice;
    private Integer count;
}
