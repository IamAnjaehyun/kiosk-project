package com.example.kiosk.dto;


import com.example.kiosk.domain.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDto {
    private Long menuID;
    private String menuName;
    private Integer price;
    private Integer menuCount;
    private String filePath;


    public Menu toEntity()  {
          Menu build = Menu.builder()
                  .menuID(menuID)
                  .menuName(menuName)
                  .price(price)
                  .menuCount(menuCount)
                  .filePath(filePath)
                  .build();
          return build;
    }

    @Builder
    public MenuDto(Long menuID, String menuName, Integer price, Integer menuCount, String filePath) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.price = price;
        this.menuCount = menuCount;
        this.filePath = filePath;
    }
}
