package com.example.kiosk.service;

import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional //db 수정하다 되돌리기 가능
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> selectMenu(){
        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }

}
//주문 완료처리 ( 목록 보고 다하면 그냥 화면에서 그 목록 삭제만 )
//사용자가 주뭄ㄴ하는거

