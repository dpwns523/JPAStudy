package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="item")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="item_id"))
public class ItemEntity extends BaseEntity {

    private String name;
    private Integer price;
    private Integer stockQuantity;
}
