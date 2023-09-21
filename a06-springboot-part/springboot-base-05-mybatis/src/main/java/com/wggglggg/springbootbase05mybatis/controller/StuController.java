package com.wggglggg.springbootbase05mybatis.controller;

import com.wggglggg.springbootbase05mybatis.model.po.Stu;
import com.wggglggg.springbootbase05mybatis.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: StuController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 20:04
 * @Version 1.0
 */
@RestController
//@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    @GetMapping("/query/all")
    public List<Stu> queryAll(){
        return stuService.queryAll();
    }

    @GetMapping("/query/{id}")
    public Stu queryById(@PathVariable Integer id){
        return stuService.queryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        int rows = stuService.deleteById(id);

        System.out.println("rows = " + rows);
        return "删除"+ id +"号成功";

    }

}
