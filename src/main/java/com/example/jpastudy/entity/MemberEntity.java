package com.example.jpastudy.entity;


import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
