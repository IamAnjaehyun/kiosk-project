package com.example.kiosk.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostMenuDTO {
    private String MenuName; // 메뉴 이름
    private int price; // 메뉴 가격
    private int menuCount;
}
