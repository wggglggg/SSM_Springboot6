package com.wggglggg.springbootbase05mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//mapper接口所在的的位置！
@MapperScan("com.wggglggg.springbootbase05mybatis.mapper")
@SpringBootApplication
public class SpringbootBase05MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBase05MybatisApplication.class, args);
	}

}
