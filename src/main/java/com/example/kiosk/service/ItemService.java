package com.example.kiosk.service;

import com.example.kiosk.domain.Repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                    .filePath(menu.getFilePath())
                    .build();

            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }

    @Transactional
    public MenuDto getMenu(Long menuID){
        Optional<Menu> menuWrapper = menuRepository.findById(menuID);
        Menu menu = menuWrapper.get();

        MenuDto menuDto = MenuDto.builder()
                .menuID(menu.getMenuID())
                .menuName(menu.getMenuName())
                .price(menu.getPrice())
                .menuCount(menu.getMenuCount())
                .filePath(menu.getFilePath())

                .build();

        return menuDto;

    }

    public void deletePost(Long menuID){
        menuRepository.deleteById(menuID);
    }
}

