package com.duyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.duyou.dao")
public class SpringBsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBsApplication.class, args);
    }

}
