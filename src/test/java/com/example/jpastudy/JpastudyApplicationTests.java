package com.example.jpastudy;


import org.springframework.boot.test.context.SpringBootTest;


//@RunWith(SpringRunner.class)
@SpringBootTest
class JpastudyApplicationTests {
//
//    @Autowired
//    private MemberService memberService;
//
//    @Autowired
//    private ItemService itemService;

//    @Test
//    @Transactional
//    void testMember() {
//        MemberEntity memberEntity = MemberEntity.builder()
//                .name("dpwns").city("Incheon").street("Bupeon").zipcode("ccc").build();
//
//        Long memberId = memberService.join(memberEntity);
//        MemberEntity memberEntity2 = memberService.findById(memberId);
//
//        Assertions.assertThat(memberId).isEqualTo(memberEntity.getId());
//        Assertions.assertThat(memberEntity.getName()).isEqualTo(memberEntity2.getName());
//    }

//    @Test
//    @Transactional
//    void testItem(){
//        ItemEntity itemEntity = new ItemEntity();
//        itemEntity.setName("물병");
//        itemEntity.setPrice(5000);
//        itemEntity.setStockQuantity(30);
//        Long itemId = itemService.registItem(itemEntity);
//        ItemEntity itemEntity2 = itemService.findById(itemId);
//
//        Assertions.assertThat(itemId).isEqualTo(itemEntity.getId());
//        Assertions.assertThat(itemEntity.getName()).isEqualTo(itemEntity2.getName());
//    }
//
//    @Test
//    @Transactional
//    void testOrder(){
//        MemberEntity memberEntity = MemberEntity.builder()
//                .name("dpwns").city("Incheon").street("Bupeon").zipcode("ccc").build();
//
//        Long memberId = memberService.join(memberEntity);
//        MemberEntity memberEntity2 = memberService.findById(memberId);
//
//        ItemEntity itemEntity = new ItemEntity();
//        itemEntity.setName("물병");
//        itemEntity.setPrice(5000);
//        itemEntity.setStockQuantity(30);
//        Long itemId = itemService.registItem(itemEntity);
//        ItemEntity itemEntity2 = itemService.findById(itemId);
//
//        OrdersEntity orderEntity = new OrdersEntity();
//        orderEntity.setStatus(OrderStatus.ORDER);
//        orderEntity.setMemberEntity(memberEntity2);
//
//        OrderItemEntity orderItemEntity = OrderItemEntity.createOrderItem(itemEntity2, 10000, 2);
//
//        orderEntity.addOrderItemEntity(orderItemEntity);
//
//        // 주문 멤버
//        Assertions.assertThat(orderEntity.getMemberEntity().getId()).isEqualTo(memberEntity2.getId());
//        // 주문가격
//        Assertions.assertThat(orderEntity.getOrderItems().get(0).getOrderPrice()).isEqualTo(10000);
//        // 주문 상품
//        Assertions.assertThat(orderEntity.getOrderItems().get(0).getItem().getId()).isEqualTo(itemEntity2.getId());
//
//
//    }


}
