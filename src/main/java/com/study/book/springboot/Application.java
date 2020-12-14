package com.study.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
 
//@EnableJpaAuditing //JPA Auditing 활성화 시키는 어노테이션 , 주석처리하고 JpaConfig.class 생성함 (p222)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
