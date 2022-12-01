package com.example.kiosk.domain.Repository;

import com.example.kiosk.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}