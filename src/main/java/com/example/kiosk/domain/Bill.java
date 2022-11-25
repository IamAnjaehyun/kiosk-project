package com.example.kiosk.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderID; // 주문 코드

    @CreatedDate
    private LocalDateTime orderedAt; //주문 시간

    protected Bill() {}

    private Bill(Long orderID) {
        OrderID = orderID;
    }
    public static Bill of (Long orderID) {
        return new Bill(orderID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill order = (Bill) o;
        return OrderID.equals(order.OrderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderID);
    }
}
