package com.example.jpastudy.service.serviceImpl;

import com.example.jpastudy.entity.Delivery;
import com.example.jpastudy.entity.Member;
import com.example.jpastudy.entity.OrderItem;
import com.example.jpastudy.entity.Orders;
import com.example.jpastudy.entity.item.Item;
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
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Orders orders = Orders.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(orders);
        return orders.getId();
    }

    @Override
    public Orders findById(Long id) {
        return orderRepository.findOne(id);
    }

    // 주문취소
    @Override
    @Transactional
    public void cancel(Long orderId) {
        Orders orders = findById(orderId);
        orders.cancel();
    }
}
