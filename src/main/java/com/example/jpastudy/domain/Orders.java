package com.example.jpastudy.domain;

import com.example.jpastudy.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders {
    @Column(name="member_id")   // 생략가능
    private Long memberId;     // 객체 지향적 문제 + 외래 키를 그대로 가져옴 -> 객체 참조가 아니기 때문에 객체 그래프 탐색을 할 수 없는 문제 발생

    @CreationTimestamp
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
