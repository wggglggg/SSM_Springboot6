package com.wggglggg.mybatisplus04wapper.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wggglggg.mybatisplus04wapper.model.po.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 10:17
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {

    @Update("""
            update user set deleted = 0 where id = #{id}
            """)
    int updateDelete(User user);

    @Select("""
            select * from user where deleted = 1
            """)
    List<User> selectAllDeletedIs1();

    @Select("""
            select * from user
            """)
    IPage<User> selectAllIncludeDeleted(IPage<?> page);
}
