package com.example.kiosk.service;

import com.example.kiosk.domain.Cart;
import com.example.kiosk.domain.Repository.CartRepository;
import com.example.kiosk.domain.Repository.MenuRepository;
import com.example.kiosk.dto.CartDto;
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
public class CartService {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Long savePost(CartDto cartDto){
        return cartRepository.save(cartDto.toEntity()).getCartID();
    }

    @Transactional
    public List<CartDto> getCartlist(){
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> cartDtoList = new ArrayList<>();

        for(Cart cart  : carts){
            CartDto cartDto = CartDto.builder()
                    .cartID(cart.getCartID())
                    .menuID(cart.getMenuID())
                    .totalPrice(cart.getTotalPrice())
                    .build();

            cartDtoList.add(cartDto);
        }
        return cartDtoList;
    }

    @Transactional
    public CartDto getCart(Long cartID){
        Optional<Cart> cartWrapper = cartRepository.findById(cartID);
        Cart cart = cartWrapper.get();

        CartDto cartDto = CartDto.builder()
                .cartID(cart.getCartID())
                .menuID(cart.getMenuID())
                .totalPrice(cart.getTotalPrice())
                .build();

        return cartDto;

    }

    public void deleteCart(Long cartID){
        cartRepository.deleteById(cartID);
    }
}



