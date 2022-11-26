package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping(value = "/index") //인덱스 페이지
    public String main(){
        return "index";
    }

    @RequestMapping(value = "/admin") //관리자 제어 페이지
    public String admin(){
        return "admin_menu";
    }

    @RequestMapping(value = "/stock") //재고 시작 페이지
    public String stock(){
        return "admin_stock";
    }

    @RequestMapping(value = "/order") //관리자 제어 페이지
    public String order(){
        return "user_order";
    }

    @RequestMapping(value = "/pay") //관리자 제어 페이지
    public String pay(){
        return "user_pay";
    }

}
