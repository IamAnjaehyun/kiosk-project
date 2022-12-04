package com.example.kiosk.service;

import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.Repository.MenuRepository;
import com.example.kiosk.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional //db 수정하다 되돌리기 가능
@Service
@RequiredArgsConstructor
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Transactional
    public Long savePost(MenuDto menuDto){
        return menuRepository.save(menuDto.toEntity()).getMenuID();
    }

    @Transactional
    public List<MenuDto> getMenulist(){
        List<Menu> menus = menuRepository.findAll();
        List<MenuDto> menuDtoList = new ArrayList<>();

        for(Menu menu : menus){
            MenuDto menuDto = MenuDto.builder()
                    .menuID(menu.getMenuID())
                    .menuName(menu.getMenuName())
                    .price(menu.getPrice())
                    .menuCount(menu.getMenuCount())
                    .build();

            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }

    public MenuDto getMenu(Long menuID){
        Optional<Menu> menuWrapper = menuRepository.findById(menuID);
        Menu menu = menuWrapper.get();

        MenuDto menuDto = MenuDto.builder()
                .menuID(menu.getMenuID())
                .menuName(menu.getMenuName())
                .price(menu.getPrice())
                .menuCount(menu.getMenuCount())
                .build();

        return menuDto;

    }

    public void deletePost(Long menuID){
        menuRepository.deleteById(menuID);
    }

    // 상품 등록
//    public void saveMenu(Menu menu, MultipartFile imgFile) throws Exception {
//
//        String oriImgName = imgFile.getOriginalFilename();
//        String imgName = "";
//
//        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
//
//        // UUID 를 이용하여 파일명 새로 생성
//        // UUID - 서로 다른 객체들을 구별하기 위한 클래스
//        UUID uuid = UUID.randomUUID();
//
//        String savedFileName = uuid + "_" + oriImgName; // 파일명 -> imgName
//
//        imgName = savedFileName;
//
//        File saveFile = new File(projectPath, imgName);
//
//        imgFile.transferTo(saveFile);
//
//        menu.setImgName(imgName);
//        menu.setImgPath("/files/" + imgName);
//
//        menuRepository.save(menu);
//    }
}


