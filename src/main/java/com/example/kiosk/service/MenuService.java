package com.example.kiosk.service;

import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional //db 수정하다 되돌리기 가능
@Service
@RequiredArgsConstructor
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> selectMenu() {
        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }

    public void commit(Menu menu){
        menuRepository.save(menu);
    }

    public void menuDelete(Long menuId){
        menuRepository.deleteById(menuId);
    }
}


