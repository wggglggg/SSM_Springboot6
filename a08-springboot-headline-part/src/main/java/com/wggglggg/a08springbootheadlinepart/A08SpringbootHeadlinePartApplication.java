package com.wggglggg.a08springbootheadlinepart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.wggglggg.a08springbootheadlinepart.mapper")
@SpringBootApplication
public class A08SpringbootHeadlinePartApplication {

    public static void main(String[] args) {
        SpringApplication.run(A08SpringbootHeadlinePartApplication.class, args);
    }

}
