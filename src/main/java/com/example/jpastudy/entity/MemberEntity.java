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

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "memberEntity")
    private List<OrdersEntity> orders = new ArrayList<OrdersEntity>();

    @Builder
    public MemberEntity(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public MemberEntity() {}
}
