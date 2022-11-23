package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/order")
    public String main(){
        return "user_order.html";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin_menu.html";
    }

}
