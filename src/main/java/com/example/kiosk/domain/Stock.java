package com.example.kiosk.domain;
//재고 통으로 설정해서 빼는것 부터 시작할 예정이라 공급처는 따로 추가하지 않았음

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StockID; //재고 코드

    @Setter @Column(nullable = false) private String StockName; //재고 이름(재료 이름)
    @Setter @Column(nullable = false) private int StockRest; //재고 갯수

    protected Stock(){}

    private Stock(Long stockID, String stockName, int stockRest) {
        StockID = stockID;
        StockName = stockName;
        StockRest = stockRest;
    }
    public static Stock of (Long stockID, String stockName, int stockRest) {
        return new Stock(stockID,stockName,stockRest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return StockID.equals(stock.StockID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StockID);
    }
}