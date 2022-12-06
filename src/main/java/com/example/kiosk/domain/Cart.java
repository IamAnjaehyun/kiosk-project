//package com.example.kiosk.domain;
//
//import lombok.Builder;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long billID; // 주문 코드
//
//    @Column(nullable = false)
//    private Long menuID;
//
//    @Builder
//    public Cart(Long billID, Long menuID) {
//        this.billID = billID;
//        this.menuID = menuID;
//    }
//}
