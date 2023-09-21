package com.wggglggg.mybatisplus02curdmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wggglggg.mybatisplus02curdmapper.mapper")
@SpringBootApplication
public class MybatisPlus02CurdMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlus02CurdMapperApplication.class, args);
	}

}
