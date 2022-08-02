package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.Base;
import com.example.jpastudy.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="delivery")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="delivery_id"))
public class Delivery extends Base {

    @OneToOne(mappedBy= "delivery")
    private Orders orders;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
