package com.example.kiosk.service;

import com.example.kiosk.domain.Repository.CartRepository;
import com.example.kiosk.dto.CartDto;
import com.example.kiosk.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional //db 수정하다 되돌리기 가능
@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    //수정해야함
    public List<CartDto> getCartlist() {
        return null;
    }

    @Transactional
    public Long savePost(CartDto cartDto){
        return cartRepository.save(cartDto.toEntity()).getCartID();
    }

    public void deletePost(Long cartID){
        cartRepository.deleteById(cartID);
    }
}