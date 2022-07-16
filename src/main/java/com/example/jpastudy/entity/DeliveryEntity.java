package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="delivery")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="delivery_id"))
public class DeliveryEntity extends BaseEntity {

    @OneToOne(mappedBy= "deliveryEntity")
    private OrdersEntity ordersEntity;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
