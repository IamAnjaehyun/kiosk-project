package com.example.kiosk.controller;

import com.example.kiosk.dto.CartDto;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/cart/post")
    public String list(Model model) {
        List<CartDto> cartDtoList = cartService.getCartlist();
        model.addAttribute("cartList", cartDtoList);

        return "user_order_cart";
    }
}
