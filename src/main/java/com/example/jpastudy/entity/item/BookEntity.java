package com.example.jpastudy.entity.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class BookEntity extends ItemEntity{
    private String author;
    private String isbn;
}
