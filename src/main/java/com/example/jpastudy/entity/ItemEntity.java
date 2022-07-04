package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.exception.NotEnoughStockException;
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

    //==비즈니스 로직==//
    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
