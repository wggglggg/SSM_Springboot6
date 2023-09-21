package com.wggglggg.mybatisplus04wapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wggglggg.mybatisplus04wapper.mapper")
@SpringBootApplication
public class MybatisPlus04WapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus04WapperApplication.class, args);
    }

}
