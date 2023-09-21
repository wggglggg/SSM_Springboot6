package com.wggglggg.springbootbase05mybatis.mapper;

import com.wggglggg.springbootbase05mybatis.model.po.Stu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: StuMapper
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 19:50
 * @Version 1.0
 */
public interface StuMapper {

    /**
     * 查询所有学生
     * @return
     */
    List<Stu> queryAll();

    /**
     * 查询某位学生
     * @param id
     * @return
     */
    @Select("""
            select * from students where id = #{id}
            """)
    @Results(id = "queryByIdMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
            @Result(column = "class", property = "stuClass")
    })
    Stu query(Integer id);


    int delete(Integer id);
}
