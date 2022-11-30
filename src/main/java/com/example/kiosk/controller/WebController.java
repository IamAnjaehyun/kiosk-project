package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/") //인덱스 페이지
    public String main(){
        return "index";
    }

//    @GetMapping("/new")
//    public String newFood(){
//        return "admin";
//    }
}