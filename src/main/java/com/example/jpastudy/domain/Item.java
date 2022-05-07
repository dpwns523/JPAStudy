package com.example.jpastudy.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    private String name;
    private Integer price;
    private Integer stockQuantity;
}
