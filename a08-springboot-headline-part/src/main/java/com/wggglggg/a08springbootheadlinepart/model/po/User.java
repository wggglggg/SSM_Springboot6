package com.wggglggg.a08springbootheadlinepart.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName news_user
 */

@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户登录名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户登录密码密文
     */
    @TableField(value = "user_pwd")
    private String userPwd;

    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @Version
    private Integer version;

    /**
     * 头条是否被删除 1 删除  0 未删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}