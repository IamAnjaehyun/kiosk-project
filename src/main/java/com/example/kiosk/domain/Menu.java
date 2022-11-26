package com.example.kiosk.domain;
//메뉴에 대한 설명은 안넣어도 될 것 같아서 안넣었음.

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuID; // 메뉴 코드

    @Column(nullable = false)
    private String menuName; // 메뉴 이름

    @Column(nullable = false)
    private int price; // 메뉴 가격

    @Column(nullable = false)
    private int menuCount;

    protected Menu() {
    }

    private Menu(Long menuID, String menuName, int price) {
        menuID = menuID;
        menuName = menuName;
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
        return menuID.equals(menu.menuID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuID);
    }
}
