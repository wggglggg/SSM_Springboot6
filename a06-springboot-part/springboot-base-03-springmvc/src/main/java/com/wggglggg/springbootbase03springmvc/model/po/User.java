package com.wggglggg.springbootbase03springmvc.model.po;

import lombok.Data;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 16:48
 * @Version 1.0
 */
@Data
public class User {

    private String username;
    private String password;
    private Integer age;
    private String gender;
}
