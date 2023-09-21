package com.wggglggg.a08springbootheadlinepart.service;

import com.wggglggg.a08springbootheadlinepart.model.po.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wggglggg.a08springbootheadlinepart.utils.Result;

import java.util.List;

/**
* @author wggglggg
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-09-20 11:17:23
*/
public interface TypeService extends IService<Type> {

    /**
     * 查询全部类别信息
     * @return
     */
    List<Type> findAllTypes();
}
