package com.example.jpastudy.entity;


import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Getter
@AttributeOverride(name = "id",column = @Column(name="member_id"))
public class MemberEntity extends BaseEntity {
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(mappedBy = "memberEntity")
    private List<OrdersEntity> orders = new ArrayList<OrdersEntity>();

    @Builder
    public MemberEntity(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public MemberEntity() {}
}
