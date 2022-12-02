package com.example.kiosk.dto;

import com.example.kiosk.domain.Cart;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartDto {
    private Long billID;
    private Long menuID;

    public Cart toEntity()  {
        Cart build = Cart.builder()
                .billID(menuID)
                .menuID(menuID)
                .build();
        return build;
    }


    @Builder
    public CartDto(Long billID, Long menuID) {
        this.billID = billID;
        this.menuID = menuID;
    }
}
