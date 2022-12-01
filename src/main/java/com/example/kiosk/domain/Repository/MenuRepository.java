package com.example.kiosk.domain.Repository;

import com.example.kiosk.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}