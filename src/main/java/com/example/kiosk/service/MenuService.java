package com.example.kiosk.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //db 수정하다 되돌리기 가능
@Service
public class MenuService {
}
//주문 완료처리 ( 목록 보고 다하면 그냥 화면에서 그 목록 삭제만 )
//사용자가 주뭄ㄴ하는거

