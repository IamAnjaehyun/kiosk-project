package com.example.kiosk.dto;


import com.example.kiosk.domain.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDto {
    private String menuName;
    private Integer price;
    private Integer menuCount;


    public Menu toEntity()  {
          Menu build = Menu.builder()
                  .menuName(menuName)
                  .price(price)
                  .menuCount(menuCount)
                  .build();
          return build;
    }

    @Builder
    public MenuDto(String menuName, Integer price, Integer menuCount) {
        this.menuName = menuName;
        this.price = price;
        this.menuCount = menuCount;
    }
}
