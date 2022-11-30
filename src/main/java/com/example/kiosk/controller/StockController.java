package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "/stock") //재고 시작 페이지
    public ModelAndView stock(){
        ModelAndView mav = new ModelAndView("admin_stock");
        List<Menu> menuList = menuService.selectMenu();
        for (Menu menu : menuList){
            logger.info("메뉴 잘 가지고 오는지 ::::::::::" + menu.getMenuID() + ", " + menu.getMenuName() + ", " + menu.getPrice());
        }
        mav.addObject("menuList", menuList);
        return mav;
    }

    @GetMapping("/stock/delete")
    public String boardDelete(Long menuId, Model model){
        menuService.menuDelete(menuId);
        model.addAttribute("message" , "글 삭제 완료.");
        model.addAttribute("SearchUrl" , "/stock");

        return "message";
    }
}
