package com.example.kiosk.controller;

import com.example.kiosk.dto.CartDto;
import com.example.kiosk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class CartController {
    //카트 조회, 추가, 삭제, 생성
    @Autowired
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    //카트창으로 들어가기
    @GetMapping("/cart")
    public String cart() {
        return "user_order_cart";
    }

    //카트조회 싹다조회
    @GetMapping("/cart")
    public String list(Model model) {
        List<CartDto> cartDtoList = cartService.getCartlist();
        model.addAttribute("cartList", cartDtoList);
        return "user_order_cart";
    }

    //카트에 등록
    @PostMapping("/cart/post")
    public String create(Model model) {
        List<CartDto> cartDtoList = cartService.getCartlist();
        model.addAttribute("cartList", cartDtoList);
        return "user_order";
    }

    //카트삭제
    @DeleteMapping("/cart/post/{cartID}")
    public String deleteCart(@PathVariable("cartID") Long cartID) {
        cartService.deleteCart(cartID);
        return "user_order_cart";
    }
}
