package com.wggglggg.mybatisplus03curdservice.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 9:14
 * @Version 1.0
 */
@Data
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private Integer age;
    private String email;
}
