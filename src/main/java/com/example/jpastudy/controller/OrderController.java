package com.example.jpastudy.controller;

import com.example.jpastudy.entity.Address;
import com.example.jpastudy.entity.OrderItem;
import com.example.jpastudy.entity.Orders;
import com.example.jpastudy.enums.OrderStatus;
import com.example.jpastudy.repository.OrderRepository;
import com.example.jpastudy.repository.order.simplequery.OrderSimpleQueryDto;
import com.example.jpastudy.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    /*
        엔티티 직접 노출
     */
    @GetMapping("api/v1/orders")
    public List<Orders> ordersV1(){
        List<Orders> all = orderRepository.findAll();
        for(Orders order : all){
            order.getMember().getName();  // Lazy 강제 초기화
            order.getDelivery().getAddress();    // Lazy 강제 초기화
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o->o.getItem().getName());  // Lazy 강제 초기화
        }
        return all;
    }
    /*
        엔티티를 조회해 DTO로 변환
     */
    @GetMapping("api/v2/orders")
    public List<SimpleOrderDto> ordersV2(){
        List<Orders> all = orderRepository.findAll();
        List<SimpleOrderDto> result = all.stream().map(o->new SimpleOrderDto(o)).collect(toList());
        return result;
    }
    /*
        엔티티를 조회해서 DTO로 변환(fetch join 사용)
     */
    @GetMapping("api/v3/orders")
    public List<SimpleOrderDto>ordersV3(){
        List<Orders> all = orderRepository.findAllWithMemberDelivery();
        List<SimpleOrderDto> result = all.stream().map(o -> new SimpleOrderDto(o)).collect(toList());
        return result;
    }

    /*
        JPA에서 DTO로 바로 조회
        쿼리 1번 호출
     */
    @GetMapping("api/v4/orders")
    public List<OrderSimpleQueryDto> ordersV4(){
        return orderSimpleQueryRepository.findOrderDtos();
    }

    @Data
    public static class SimpleOrderDto{
        private Long orderId;
        private String name;
        private Timestamp orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Orders orders){
            orderId= orders.getId();
            name= orders.getMember().getName();
            orderDate = orders.getCreatedAt();
            orderStatus = orders.getStatus();
            address = orders.getDelivery().getAddress();
        }
    }
}
