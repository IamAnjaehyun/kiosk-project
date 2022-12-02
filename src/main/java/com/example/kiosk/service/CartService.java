//package com.example.kiosk.service;
//
//import com.example.kiosk.domain.Cart;
//import com.example.kiosk.dto.CartDto;
//import com.example.kiosk.dto.MenuDto;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional //db 수정하다 되돌리기 가능
//@Service
//public class CartService {
//
//    @javax.transaction.Transactional
//    public List<MenuDto> getCartlist(){
//        List<Cart> carts = cartRepository.findAll();
//        List<CartDto> cartDtoList = new ArrayList<>();
//
//        for(Cart cart : carts){
//            CartDto cartDto = CartDto.builder()
//                    .cartId(cart.getCartID())
//                    .menuId(cart.getMenuID())
//                    .price(cart.getPrice())
//                    .menuCount(cart.getMenuCount())
//                    .build();
//
//            cartDtoList.add(cartDto);
//        }
//        return cartDtoList;
//    }
//}
