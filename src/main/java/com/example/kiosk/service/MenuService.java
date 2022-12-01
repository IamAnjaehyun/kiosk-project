package com.example.kiosk.service;

import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.domain.Menu;
import com.example.kiosk.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Transactional //db 수정하다 되돌리기 가능
@Service
@RequiredArgsConstructor
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    public List<Menu> selectMenu() {
        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }

    @Transactional
    public Long savePost(MenuDto menuDto){
        return menuRepository.save(menuDto.toEntity()).getMenuID();
    }

    public void menuDelete(Long menuID){
        menuRepository.deleteById(menuID);
    }
}


