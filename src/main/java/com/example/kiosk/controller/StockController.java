package com.example.kiosk.controller;

import com.example.kiosk.dto.CartDto;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.CartService;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StockController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private CartService cartService;

    @GetMapping("/stock")
    public String stock(Model model){
        List<MenuDto> menuDtoList = menuService.getMenulist();
        List<CartDto> cartDtoList = cartService.getCartlist();
        model.addAttribute("menuList", menuDtoList);
        model.addAttribute("cartList", cartDtoList);

        return "admin_stock";
    }

    //삭제
    @DeleteMapping("/stock/delete/{cartID}")
    public String delete(@PathVariable("cartID") Long cartID) {
        cartService.deleteCart(cartID);

        return "admin_stock";
    }
}
