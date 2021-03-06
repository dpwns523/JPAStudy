package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.entity.item.ItemEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
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
