package com.example.kiosk.Repository;

import com.example.kiosk.config.JpaConfig;
import com.example.kiosk.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스ㅌ트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final MenuRepository menuRepository;
    private final BillRepository billRepository;

    public JpaRepositoryTest(
            @Autowired MenuRepository menuRepository,
            @Autowired BillRepository billRepository,
            @Autowired StockRepository stockRepository) {
        this.menuRepository = menuRepository;
        this.billRepository = billRepository;
        this.stockRepository = stockRepository;
    }

    private final StockRepository stockRepository;

    @DisplayName("select test")
    @Test
    void given_when_then(){
        //given

        //when
        List< Menu> menus = menuRepository.findAll();
        //then
        assertThat(menus)
                .isNotNull()
                .hasSize(1);
    }

}