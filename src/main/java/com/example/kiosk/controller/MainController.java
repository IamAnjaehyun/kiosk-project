package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/order") //고객주문페이지
    public String main(){
        return "user_order.html";
    }

    @RequestMapping(value = "/admin") //관리자 제어 페이지
    public String admin(){
        return "admin_menu.html";
    }

}
