package com.example.kiosk.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//카트 하나에 여러개의 상품이 담길 수 있어야함


@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartID; //카트 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuName")
    private Menu menuID;

    @Column(nullable = true)
    private Integer totalPrice; //총액

    @Builder
    public Cart(Long cartID, Menu menuID, Integer totalPrice) {
        this.cartID = cartID;
        this.menuID = menuID;
        this.totalPrice = totalPrice; //총액 어케?
    }
}