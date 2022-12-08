package com.example.kiosk.domain;
//메뉴에 대한 설명은 안넣어도 될 것 같아서 안넣었음.

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
public class Menu {

    @Id
    @JoinColumn(name = "menuID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuID; // 메뉴 코드

    @Column(nullable = false)
    private String menuName; // 메뉴 이름

    @Column(nullable = false)
    private Integer price; // 메뉴 가격

    @Column(nullable = false)
    private Integer menuCount; // 재고량

    @Column(nullable = true)
    private String filePath;

//    private String imgName;
//    private String imgPath;

    @Builder
    public Menu(Long menuID, String menuName, Integer price, Integer menuCount, String filePath) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.price = price;
        this.menuCount = menuCount;
        this.filePath = filePath;
    }
}
