package com.example.kiosk.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MenuDTO {
    private Long MenuID; // 메뉴 코드 자동생성 되면 좋음
    private String MenuName; // 메뉴 이름
    private int price; // 메뉴 가격

    public Long getMenuID() {
        return MenuID;
    }

    public void setMenuID(Long menuID) {
        MenuID = menuID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "MenuID=" + MenuID +
                ", MenuName='" + MenuName + '\'' +
                ", price=" + price +
                '}';
    }
}
