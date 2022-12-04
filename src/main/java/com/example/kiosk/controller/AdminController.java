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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;

    public AdminController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<MenuDto> menuDtoList = menuService.getMenulist();
        model.addAttribute("menuList", menuDtoList);

        return "admin_menu";
    }

    @GetMapping("/post")
    public String write() {
        return "write";
    }

    @PostMapping("/post")
    public String write(MenuDto menuDto) {
        menuService.savePost(menuDto);
        return "redirect:/";
    }

    @GetMapping("/post/{menuID}")
    public String detail(@PathVariable("menuID") Long menuID, Model model) {
        MenuDto menuDto = menuService.getMenu(menuID);

        model.addAttribute("menuDto", menuDto);
        return "detail";
    }


    @GetMapping("/post/edit/{menuID}")
    public String edit(@PathVariable("menuID") Long menuID, Model model) {
        MenuDto menuDto = menuService.getMenu(menuID);

        model.addAttribute("menuDto", menuDto);
        return "update";
    }

    @PutMapping("/post/edit/{menuID}")
    public String update(MenuDto menuDto) {
        menuService.savePost(menuDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{menuID}")
    public String delete(@PathVariable("menuID") Long menuID) {
        menuService.deletePost(menuID);

        return "redirect:/";
    }
//    보고 사진추가 기능 구현하기
//    https://velog.io/@rladuswl/8-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8A%A4%ED%84%B0%EB%94%94-%EC%87%BC%ED%95%91%EB%AA%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%83%81%ED%92%88-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%97%85%EB%A1%9C%EB%93%9C%EC%99%80-thymeleaf

//    @PostMapping("/post/img/{menuID}")
//    public String itemSave(@PathVariable("menuID") Menu menu, MultipartFile imgFile) throws Exception {
//        menuService.saveMenu(menu, imgFile);
//        return "redirect:/";
//    }
}
