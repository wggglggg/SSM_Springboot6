package com.wggglggg.springboot.controller;

import com.wggglggg.springboot.model.po.Stu;
import com.wggglggg.springboot.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 17:48
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getUser")
    @ResponseBody
    public Stu getUser(){
        String sql = "select id, name, gender,age,class as stuClass from students where id = ?";
        Stu stu = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Stu.class), 1);

        log.info("查询的user数据为:{}",stu.toString());
        return stu;
    }
}
