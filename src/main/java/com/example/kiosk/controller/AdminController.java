package com.example.kiosk.controller;

import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.service.MenuService;
import com.example.kiosk.util.MD5Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private MenuService menuService;


    public AdminController(MenuService menuService) {
        this.menuService = menuService;
//        this.fileService = fileService;
    }


    //조회
    @GetMapping("/")
    public String list(Model model) {
        List<MenuDto> menuDtoList = menuService.getMenulist();
//        List<FileDto> fileDtoList = fileService.getFilelist();
        model.addAttribute("menuList", menuDtoList);
//        model.addAttribute("fileList", fileDtoList);

        return "admin_menu";
    }

    //등록
    @GetMapping("/post")
    public String write() {
        return "write";
    }

    //사진등록
    @PostMapping("/post")
    public String write(@RequestParam("file") MultipartFile files, MenuDto menuDto) {
        try {
            String origFilename = files.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
            String savePath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            String realfilePath = savePath + filename;
            files.transferTo(new File(realfilePath));

            String filePath = "/files/" + filename;
            menuDto.setFilePath(filePath);
            menuService.savePost(menuDto);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }




    //상세보기
    @GetMapping("/post/{menuID}")
    public String detail(@PathVariable("menuID") Long menuID, Model model) {
        List<MenuDto> menuDtoList = menuService.getMenulist();
//        List<FileDto> fileDtoList = fileService.getFilelist();
        model.addAttribute("menuList", menuDtoList);
//        model.addAttribute("fileList", fileDtoList);
        return "detail";
    }

    //수정
    @GetMapping("/post/edit/{menuID}")
    public String edit(@PathVariable("menuID") Long menuID, Model model) {
        List<MenuDto> menuDtoList = menuService.getMenulist();
//        List<FileDto> fileDtoList = fileService.getFilelist();
        model.addAttribute("menuList", menuDtoList);
//        model.addAttribute("fileList", fileDtoList);
        return "update";
    }

    //수정 후 저장
    @PutMapping("/post/edit/{menuID}")
    public String update(MenuDto menuDto) {
        menuService.savePost(menuDto);
        return "redirect:/";
    }

    //삭제
    @DeleteMapping("/post/{menuID}")
    public String delete(@PathVariable("menuID") Long menuID) {
        menuService.deletePost(menuID);

        return "redirect:/";
    }

}
