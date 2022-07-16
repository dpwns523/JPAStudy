package com.example.jpastudy.entity;

import com.example.jpastudy.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@AttributeOverride(name = "id",column = @Column(name="category_id"))
public class CategoryEntity extends BaseEntity {
    private String name;

    @ManyToMany
    @JoinTable(name="category_item",
                joinColumns = @JoinColumn(name="category_id"),
                inverseJoinColumns = @JoinColumn(name="item_id"))
    private List<ItemEntity> itemEntities = new ArrayList<>();

    // 카테고리의 계층 구조를 위한 필드들
    @ManyToOne
    @JoinColumn(name="parent_id")
    private CategoryEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<CategoryEntity> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(CategoryEntity child){
        this.child.add(child);
        child.setParent(this);
    }

}
