//package com.example.kiosk.domain;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class CartProduct {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "CART_ID")
//    private Cart cart;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Menu menu;
//}