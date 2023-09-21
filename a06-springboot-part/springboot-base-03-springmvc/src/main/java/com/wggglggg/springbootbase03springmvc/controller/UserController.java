package com.wggglggg.springbootbase03springmvc.controller;

import com.wggglggg.springbootbase03springmvc.model.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 16:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(){

        User user = new User();
        user.setUsername("杨过");
        user.setPassword("123456");
        user.setAge(28);
        user.setGender("男");

        return user;
    }
}
