package com.example.jpastudy.entity.item;

import com.example.jpastudy.entity.CategoryEntity;
import com.example.jpastudy.entity.base.BaseEntity;
import com.example.jpastudy.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="item_id"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
public abstract class ItemEntity extends BaseEntity {

    private String name;
    private Integer price;
    private Integer stockQuantity;

    @ManyToMany(mappedBy = "itemEntities")
    private List<CategoryEntity> categoryEntities = new ArrayList<>();

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
