package com.example.kiosk.domain;
//메뉴에 대한 설명은 안넣어도 될 것 같아서 안넣었음.

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MenuID; // 메뉴 코드

    @Setter
    @Column(nullable = false)
    private String MenuName; // 메뉴 이름
    @Setter
    @Column(nullable = false)
    private int price; // 메뉴 가격

    protected Menu() {
    }

    private Menu(Long menuID, String menuName, int price) {
        MenuID = menuID;
        MenuName = menuName;
        this.price = price;
    }

    public static Menu of(Long menuID, String menuName, int price) {
        return new Menu(menuID,menuName,price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return MenuID.equals(menu.MenuID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MenuID);
    }
}
