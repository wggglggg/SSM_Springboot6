package com.wggglggg.mybatisplus04wapper.generator.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    private Integer age;

    private String email;


    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;

    private static final long serialVersionUID = 1L;
}