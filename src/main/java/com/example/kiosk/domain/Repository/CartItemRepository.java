package com.example.kiosk.domain.Repository;

import com.example.kiosk.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cart, Long> {
}