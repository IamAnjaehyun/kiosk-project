package com.example.kiosk.domain;
//메뉴에 대한 설명은 안넣어도 될 것 같아서 안넣었음.

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuID; // 메뉴 코드

    @Column
    private String menuName; // 메뉴 이름

    @Column
    private int price; // 메뉴 가격

    @Column
    private int menuCount;

    public Menu(String menuName, int price, int menuCount) {
        this.menuName = menuName;
        this.price = price;
        this.menuCount = menuCount;
    }
    //
//    protected Menu() {
//    }
//
//    private Menu(Long menuID, String menuName, int price) {
//        menuID = menuID;
//        menuName = menuName;
//        this.price = price;
//    }
//
//    public static Menu of(Long menuID, String menuName, int price) {
//        return new Menu(menuID,menuName,price);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Menu)) return false;
//        Menu menu = (Menu) o;
//        return menuID.equals(menu.menuID);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(menuID);
//    }
//--------

//    public void decrease(final int menuCount) {
//        if (this.menuCount - menuCount < 0) {
//            throw new RuntimeException("재고 부족");
//        }
//        this.menuCount = this.menuCount - menuCount;
//    }

    //내일 해보기
//    public static Menu createOrdermenu(Menu menu, int menuCount){
//        Menu orderMenu = new Menu();
//
//        orderMenu.setItem(item);//주문상품
//        orderMenu.setCount(count);//주문수량
//        //현재시간 기준으로 상품 가격을 주문 가격으로 세팅합니다. 상품 가격은 시간에 따라서 달라질수 있습니다. 또한 쿠폰이나 할인을 적용하는 케이스들도 있지만 여기서는 고려하지 않겠습니다.
//        orderMenu.setOrderPrice(item.getPrice());
//        //주문수량만큼의 상품의 재고 수량을 감소시킵니다.
//        menu.removeStock(menuCount);
//        return  orderItem;
//    }
    //주문가격과 주문 수량을 곱해서 해당 상품을 주문한 총 가격을 계산하는 메소드입니다.
//    public  int getTotalPrice(){
//        return  orderPrice * count;
//    }
}
