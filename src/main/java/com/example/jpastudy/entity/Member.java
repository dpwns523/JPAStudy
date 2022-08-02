package com.example.jpastudy.entity;


import com.example.jpastudy.entity.base.Base;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Getter
@AttributeOverride(name = "id",column = @Column(name="member_id"))
public class Member extends Base {
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<Orders>();

    @Builder
    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Member() {}
}
