package com.example.kiosk.dto;

import com.example.kiosk.domain.Cart;
import com.example.kiosk.domain.Menu;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
public class CartDto {

    private Long cartID;
    private Long menuID;
    // 총액
    private Integer totalPrice;

    public Cart toEntity()  {
        Cart build = Cart.builder()
                .cartID(cartID)
                .menuID(menuID)
                .totalPrice(totalPrice)
                .build();
        return build;
    }

    @Builder
    public CartDto(Long cartID, Long menuID, Integer menuCount,  Integer totalPrice) {
        this.cartID = cartID;
        this.menuID = menuID;
        this.totalPrice = totalPrice;
    }
}