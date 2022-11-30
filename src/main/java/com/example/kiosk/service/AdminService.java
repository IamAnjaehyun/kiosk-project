package com.example.kiosk.service;

import com.example.kiosk.Repository.AdminRepository;
import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    //메뉴 추가 삭제 수정 해야됨

//    @Transactional
//    public synchronized void decrease(final Long id, final Long quantity) {
//        Menu menu = menuRepository.findById(id).orElseThrow();
//        menu.decrease(quantity);
//        menuRepository.saveAndFlush(stock);
//    }
}