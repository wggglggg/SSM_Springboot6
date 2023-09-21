package com.wggglggg.mybatisplus04wapper.model.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 9:14
 * @Version 1.0
 */

//@TableName //可以不加， 使用实体类的名字作为表名 ！ 忽略大小写
//BaseMapper -> User实体类 -》 实体类的名 -> 表名数据库操作
//当数据库的表名和实体类命名不同（忽略大小写），使用@TableName注解指定表名

//@TableName("t_user")
@Data
public class User {

    /**
     * 默认： 雪花算法  1. 数据库主键 bigint / varchar(64)
     *                 2. 实体类Long类型
     *                 3. 随机生成一个数字，给与主键值（不重复）
     *        auto     1. mysql数据库 表主键的时候 类型 数字 auto_increment
     *                 2. 插入数据自增长了
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //  数据库字段名   是否为数据库表字段
    @TableField(value = "name", exist = true)
    private String name;
    private Integer age;
    private String email;

    //当前属性对应的列就是逻辑删除的状态字段
    //当你删除数据的时候，自动变成修改此列的属性值 默认 0 未删除  1 删除
    //当你查询数据的时候，默认只查询 deleted = 0
    @TableLogic
    private Integer deleted;

    @Version
    private Integer version;        //版本号字段
}
