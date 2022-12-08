package com.example.kiosk.controller;

import com.example.kiosk.dto.CartDto;
import com.example.kiosk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class CartController {
    //카트 조회, 추가, 삭제, 생성
    @Autowired
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

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

    //삭제
    @DeleteMapping("/cart/post/{cartID}")
    public String delete(@PathVariable("menuID") Long menuID) {
        cartService.deletePost(menuID);
        return "user_order_cart";
    }
}
