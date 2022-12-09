package com.example.kiosk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //주문시간 위한 생성일자 or 수정일자 자동으로 등록해주는 어노테이션
@Configuration
public class JpaConfig {
}
