package com.wggglggg.mybatisplus02curdmapper.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/18 20:43
 * @Version 1.0
 */

@Data
public class User {

    // TableId注解使Insert into 时可以自增长
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
