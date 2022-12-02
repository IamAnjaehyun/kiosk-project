//package com.example.kiosk.controller;
//
//import com.example.kiosk.dto.CartDto;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//@Controller
//public class CartController {
//    @GetMapping("/")
//    public String list(Model model){
//        List<CartDto> cartDtoList = cartService.getMenulist();
//        model.addAttribute("cartlist",cartDtoList);
//
//        return "cart...";
//    }
//}
