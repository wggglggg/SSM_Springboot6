package com.wggglggg.springbootbase05mybatis.service;

import com.wggglggg.springbootbase05mybatis.mapper.StuMapper;
import com.wggglggg.springbootbase05mybatis.model.po.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: StuService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 20:01
 * @Version 1.0
 */
@Service
public class StuService {

    @Autowired
    private StuMapper stuMapper;

    public List<Stu> queryAll(){
        return stuMapper.queryAll();
    }

    public Stu queryById(Integer id){
        return stuMapper.query(id);
    }

    @Transactional
    public int deleteById(Integer id){
        int rows = stuMapper.delete(id);
        int i = 1 / 0;
        return rows;
    }
}
