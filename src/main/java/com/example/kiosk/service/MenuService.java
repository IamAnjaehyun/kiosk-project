package com.example.kiosk.service;

import com.example.kiosk.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //db 수정하다 되돌리기 가능
@Service
public class MenuService {
    //아이디 이름 가격
//    public static MenuDTO createNewMenu(){
//        long newID = 1;
//        String newName = "햄버거";
//        int newPrice = 5000;
//
//        MenuDTO menuDTO = new MenuDTO(newID,newName,newPrice);
//        //생성자 지웠음 일단
//
//        return menuDTO;
//        //이걸 입력받고 삽입해야 하는..?
//    }
}
//주문 완료처리 ( 목록 보고 다하면 그냥 화면에서 그 목록 삭제만 )
//사용자가 주뭄ㄴ하는거

