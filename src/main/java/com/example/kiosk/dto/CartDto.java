package com.example.kiosk.dto;

import com.example.kiosk.domain.Cart;
import com.example.kiosk.domain.Menu;
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

    public Cart toEntity()  {
        Cart build = Cart.builder()
                .cartID(cartID)
                .menuID(menuID)
                .menuCount(menuCount)
                .price(price)
                .totalPrice(totalPrice)
                .build();
        return build;
    }

    @Builder
    public CartDto(Long cartID, Long menuID, Integer menuCount, Integer price, Integer totalPrice) {
        this.cartID = cartID;
        this.menuID = menuID;
        this.menuCount = menuCount;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}