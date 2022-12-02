package com.example.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/index") //인덱스 페이지
    public String main(){
        return "index";
    }
}
