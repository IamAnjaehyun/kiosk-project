package com.example.kiosk.controller;

import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StockController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;
//    @Autowired
//    private FileService fileService;

    @GetMapping("/stock")
    public String stock(Model model){
        List<MenuDto> menuDtoList = menuService.getMenulist();
//        List<FileDto> fileDtoList = fileService.getFilelist();
        model.addAttribute("menuList", menuDtoList);
//        model.addAttribute("fileList", fileDtoList);

        return "admin_stock";
    }

}
