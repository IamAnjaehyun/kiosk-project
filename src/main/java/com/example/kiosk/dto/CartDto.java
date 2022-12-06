package com.example.kiosk.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
public class CartDto {

    private Long cartID;
    private Long menuID;
    private Integer menuCount;
    private Integer price;
    // 총액
    private Integer totalPrice;

    @Builder
    public CartDto(Long cartID, Long menuID, Integer menuCount, Integer price, Integer totalPrice) {
        this.cartID = cartID;
        this.menuID = menuID;
        this.menuCount = menuCount;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}