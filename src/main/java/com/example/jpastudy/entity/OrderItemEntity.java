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

    private Integer orderPrice;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private OrdersEntity ordersEntity;

    //==생성 메서드==//
    public static OrderItemEntity createOrderItem(ItemEntity itemEntity, int orderPrice, int count) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setItem(itemEntity);
        orderItemEntity.setOrderPrice(orderPrice);
        orderItemEntity.setCount(count);

        itemEntity.removeStock(count);
        return orderItemEntity;
    }

    //==비즈니스 로직==//
    public void cancel() {
        getItem().addStock(count);
    }
}
