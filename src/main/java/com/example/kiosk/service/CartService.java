package com.example.kiosk.service;

import com.example.kiosk.domain.Cart;
import com.example.kiosk.domain.CartItem;
import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.Repository.CartItemRepository;
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
    private CartRepository cartRepository;
    private MenuRepository menuRepository;
    private CartItemRepository cartItemRepository;

    @Transactional
    public void addCart(Menu newMenu, int amount) {


        Cart cart = new Cart();
        cartRepository.save(cart);

        Menu menu = menuRepository.findMenuById(newMenu.getMenuID());
        CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        // 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가
        if (cartItem == null) {
            cartItem = CartItem.createCartItem(cart, item, amount);
            cartItemRepository.save(cartItem);
        }

        // 상품이 장바구니에 이미 존재한다면 수량만 증가
        else {
            CartItem update = cartItem;
            update.setCart(cartItem.getCart());
            update.setItem(cartItem.getItem());
            update.addCount(amount);
            update.setCount(update.getCount());
            cartItemRepository.save(update);
        }

        // 카트 상품 총 개수 증가
        cart.setCount(cart.getCount() + amount);

    }
//
//    @Autowired
//    private MenuRepository menuRepository;
//    @Autowired
//    private CartRepository cartRepository;
//
//    public CartService(CartRepository cartRepository){
//        this.cartRepository = cartRepository;
//    }
//
//    @Transactional
//    public Long savePost(CartDto cartDto){
//        return cartRepository.save(cartDto.toEntity()).getCartID();
//    }
//
//    @Transactional
//    public List<CartDto> getCartlist(){
//        List<Cart> carts = cartRepository.findAll();
//        List<CartDto> cartDtoList = new ArrayList<>();
//
//        for(Cart cart  : carts){
//            CartDto cartDto = CartDto.builder()
//                    .cartID(cart.getCartID())
//                    .menuID(cart.getMenuID())
//                    .totalPrice(cart.getTotalPrice())
//                    .build();
//
//            cartDtoList.add(cartDto);
//        }
//        return cartDtoList;
//    }
//
//    @Transactional
//    public CartDto getCart(Long cartID){
//        Optional<Cart> cartWrapper = cartRepository.findById(cartID);
//        Cart cart = cartWrapper.get();
//
//        CartDto cartDto = CartDto.builder()
//                .cartID(cart.getCartID())
//                .menuID(cart.getMenuID())
//                .totalPrice(cart.getTotalPrice())
//                .build();
//
//        return cartDto;
//
//    }
//
//    public void deleteCart(Long cartID){
//        cartRepository.deleteById(cartID);
//    }
}



