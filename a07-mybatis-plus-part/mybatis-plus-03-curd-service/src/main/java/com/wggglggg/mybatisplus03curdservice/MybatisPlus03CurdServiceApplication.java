package com.wggglggg.mybatisplus03curdservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wggglggg.mybatisplus03curdservice.mapper")
@SpringBootApplication
public class MybatisPlus03CurdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus03CurdServiceApplication.class, args);
    }

}
