package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "/index") //인덱스 페이지
    public String main(){
        return "index";
    }

//    @RequestMapping(value = "/admin") //관리자 제어 페이지
//    public String admin(){
//        return "admin_menu";
//    }

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

    @RequestMapping(value = "/order") //관리자 제어 페이지
    public ModelAndView order(){
        ModelAndView mav = new ModelAndView("user_order");
        List<Menu> menuList = menuService.selectMenu();
        for (Menu menu : menuList){
            logger.info("메뉴 잘 가지고 오는지 ::::::::::" + menu.getMenuID() + ", " + menu.getMenuName() + ", " + menu.getPrice());
        }
        mav.addObject("menuList", menuList);
        return mav;
    }

    @RequestMapping(value = "/admin") //관리자 제어 페이지
    public ModelAndView admin(){
        ModelAndView mav2 = new ModelAndView("admin_menu");
        List<Menu> menuList = menuService.selectMenu();
        for (Menu menu : menuList){
            logger.info("메뉴 잘 가지고 오는지 ::::::::::" + menu.getMenuID() + ", " + menu.getMenuName() + ", " + menu.getPrice());
        }
        mav2.addObject("menuList", menuList);
        return mav2;
    }



    @RequestMapping(value = "/pay") //관리자 제어 페이지
    public String pay(){
        return "user_pay";
    }

}
