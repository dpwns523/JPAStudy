package com.example.jpastudy.service.serviceImpl;

import com.example.jpastudy.entity.DeliveryEntity;
import com.example.jpastudy.entity.MemberEntity;
import com.example.jpastudy.entity.OrderItemEntity;
import com.example.jpastudy.entity.OrdersEntity;
import com.example.jpastudy.entity.item.ItemEntity;
import com.example.jpastudy.enums.DeliveryStatus;
import com.example.jpastudy.repository.ItemRepository;
import com.example.jpastudy.repository.MemberRepository;
import com.example.jpastudy.repository.OrderRepository;
import com.example.jpastudy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // 주문
    @Override
    public Long Order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        MemberEntity memberEntity = memberRepository.findOne(memberId);
        ItemEntity itemEntity = itemRepository.findOne(itemId);

        //배송정보 생성
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setCity(memberEntity.getCity());
        deliveryEntity.setStreet(memberEntity.getStreet());
        deliveryEntity.setZipcode(memberEntity.getZipcode());
        deliveryEntity.setStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderItemEntity orderItemEntity = OrderItemEntity.createOrderItem(itemEntity, itemEntity.getPrice(), count);

        //주문 생성
        OrdersEntity ordersEntity = OrdersEntity.createOrder(memberEntity, deliveryEntity, orderItemEntity);

        //주문 저장
        orderRepository.save(ordersEntity);
        return ordersEntity.getId();
    }

    @Override
    public OrdersEntity findById(Long id) {
        return orderRepository.findOne(id);
    }

    // 주문취소
    @Override
    @Transactional
    public void cancel(Long orderId) {
        OrdersEntity ordersEntity = findById(orderId);
        ordersEntity.cancel();
    }
}
