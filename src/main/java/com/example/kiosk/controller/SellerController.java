package com.example.kiosk.controller;

import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;


    @GetMapping("/order")
    public String order(Model model){
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("menuList", menuDtoList);
        return "user_order";
    }

    @GetMapping("/order/post/{menuID}")
    public String detail(@PathVariable("menuID") Long menuID, Model model){
        MenuDto menuDto = menuService.getMenu(menuID);
        model.addAttribute("menuDto",menuDto);
        return "user_order_detail";
    }

}
