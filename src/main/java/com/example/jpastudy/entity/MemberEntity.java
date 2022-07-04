package com.example.jpastudy.entity;


import com.example.jpastudy.domain.Orders;
import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="member_id"))
public class MemberEntity extends BaseEntity {
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "memberEntity")
    private List<OrdersEntity> orders = new ArrayList<OrdersEntity>();


}
