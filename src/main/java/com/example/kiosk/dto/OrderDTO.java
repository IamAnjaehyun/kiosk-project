package com.example.kiosk.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private String menuName;
    private int price;
    private int menuCount;

}
