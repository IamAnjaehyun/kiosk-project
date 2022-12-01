package com.example.kiosk.controller;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;

    public AdminController(MenuService menuService){
        this.menuService=menuService;
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

    @GetMapping("/post")
    public String write(){
        return "write";
    }

    @PostMapping("/post")
    public String write(MenuDto menuDto){
        menuService.savePost(menuDto);
        return "redirect:/admin";
    }
//    @GetMapping("/admin/commit") //localhost:8090/admin/commit
//    public String menuWriteForm(){
//
//        return "redirect:admin";
//    }
//
//    @GetMapping("/post")
//    public String menuWritePro(Menu menu, Model model){
//        menuService.commit(menu);
//        model.addAttribute("message" , "글 등록 완료.");
//        model.addAttribute("SearchUrl" , "/admin");
//
//        return "message";
//    }
}
