package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;

    @GetMapping("/stock")
    public String stock(Model model){
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("menuList",menuDtoList);

        return "user_stock";
    }

}
