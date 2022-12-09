package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.dto.CartDto;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.CartService;
import com.example.kiosk.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class UserController {
    //카트 조회, 추가, 삭제, 생성
    private CartService cartService;

    private MenuService menuService;

    public UserController(CartService cartService){
        this.cartService = cartService;
    }

    //카트창으로 들어가기
    @GetMapping("/cart")
    public String cart() {
        return "user_order_cart";
    }

    //카트조회 싹다조회
    @GetMapping("/cart/list")
    public String list(Model model) {
        List<CartDto> cartDtoList = cartService.getCartlist();
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("cartList", cartDtoList);
        model.addAttribute("menuList", menuDtoList);

        return "user_order_cart";
    }

    //카트에 등록
    @PostMapping("/cart/post")
    public String create(Model model) {
        List<CartDto> cartDtoList = cartService.getCartlist();
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("cartList", cartDtoList);
        model.addAttribute("menuList", menuDtoList);
        return "user_order";
    }

    //카트삭제
    @DeleteMapping("/cart/post/{cartID}")
    public String deleteCart(@PathVariable("cartID") Long cartID) {
        cartService.deleteCart(cartID);
        return "user_order_cart";
    }

    @PostMapping("/user/cart/{id}/{menuID}")
    public String addCartItem( @PathVariable("menuID") Long menuID, int amount) {

        Menu item = menuService.getMenulist(menuID);

        cartService.savePost(user, item, amount);

        return "redirect:/item/view/{itemId}";
    }
}
