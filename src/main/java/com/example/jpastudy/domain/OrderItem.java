package com.example.jpastudy.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {
    private Long itemId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생
    private Long orderId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생

    private Integer orderPrice;
    private Integer count;
}
