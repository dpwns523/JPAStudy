package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="order_id"))
public class OrdersEntity extends BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private MemberEntity memberEntity;

    @OneToMany(mappedBy = "ordersEntity", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity deliveryEntity;

    //==연관관계 메소드==//
    public void setMemberEntity(MemberEntity memberEntity){
        // 기존관계 제거
        if(this.memberEntity != null){
            this.memberEntity.getOrders().remove(this);
        }
        this.memberEntity = memberEntity;
        memberEntity.getOrders().add(this);
    }

    public void addOrderItemEntity(OrderItemEntity orderItemEntity){
        orderItems.add(orderItemEntity);
        orderItemEntity.setOrdersEntity(this);
    }

    public void setDeliveryEntity(DeliveryEntity deliveryEntity){
        this.deliveryEntity = deliveryEntity;
        deliveryEntity.setOrdersEntity(this);
    }
    //==비즈니스 로직==//
    /**
     * 주문 취소
     */
    public void cancel() {
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItemEntity orderItem : orderItems) {
            orderItem.cancel();
        }
    }

}
