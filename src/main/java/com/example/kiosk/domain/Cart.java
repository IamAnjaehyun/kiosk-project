package com.example.kiosk.domain;

import lombok.*;

import javax.persistence.*;

//카트 하나에 여러개의 상품이 담길 수 있어야함


@Data
@NoArgsConstructor
@Getter@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID;

    @JoinColumn(name = "menuID")
    private Long menuID;

    private Integer menuCount;
    private Integer price;

    // 총액
    private Integer totalPrice;

    @Builder
    public Cart(Long cartID, Long menuID, Integer menuCount, Integer price, Integer totalPrice) {
        this.cartID = cartID;
        this.menuID = menuID;
        this.menuCount = menuCount;
        this.price = price;
        this.totalPrice = totalPrice; //총액 어케?
    }


}