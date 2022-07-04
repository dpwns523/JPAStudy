package com.example.jpastudy.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {
    private Integer orderPrice;
    private Integer count;

    private Item item;
    private Orders orders;
}
