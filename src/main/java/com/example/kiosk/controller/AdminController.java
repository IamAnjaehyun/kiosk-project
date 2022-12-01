package com.example.kiosk.controller;

import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;

    public AdminController(MenuService menuService){
        this.menuService=menuService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("menuList",menuDtoList);

        return "admin_menu";
    }

<<<<<<< Updated upstream
    @GetMapping("/post")
    public String write(){
        return "write";
    }

    @PostMapping("/post")
    public String write(MenuDto menuDto){
        menuService.savePost(menuDto);
        return "redirect:/";
    }

    @GetMapping("/post/{menuID}")
    public String detail(@PathVariable("menuID") Long menuID, Model model){
        MenuDto menuDto = menuService.getMenu(menuID);

        model.addAttribute("menuDto",menuDto);
        return "detail";
    }


    @GetMapping("/post/edit/{menuID}")
    public String edit(@PathVariable("menuID") Long menuID, Model model){
        MenuDto menuDto = menuService.getMenu(menuID);

        model.addAttribute("menuDto",menuDto);
        return "update";
    }

    @PutMapping("/post/edit/{menuID}")
    public String update(MenuDto menuDto){
        menuService.savePost(menuDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{menuID}")
    public String delete(@PathVariable("menuID") Long menuID){
        menuService.deletePost(menuID);
=======
    @PostMapping("/admin/commitmenu")
    public String menuWritePro(Menu menu, Model model){
        menuService.commit(menu);
        List<Menu> menuList = menuService.selectMenu();
        for (Menu menu1 : menuList){
            logger.info("메뉴 잘 가지고 오는지 ::::::::::" + menu1.getMenuID() + ", " + menu1.getMenuName() + ", " + menu1.getPrice());
        }
        model.addAttribute("message" , "상품 등록 완료.");
        model.addAttribute("SearchUrl" , "/admin");
>>>>>>> Stashed changes

        return "redirect:/";
    }
    
}
