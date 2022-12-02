package com.example.kiosk.domain;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billID; // 주문 코드

    @Column(nullable = false)
    private Long menuID;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    private Set<CartProduct> wishList = new java.util.LinkedHashSet<>();

    public Set<CartProduct> getWishList() {
        return wishList;
    }

    public void setWishList(Set<CartProduct> wishList) {
        this.wishList = wishList;
    }
}
