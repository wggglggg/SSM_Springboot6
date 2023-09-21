package com.wggglggg.a08springbootheadlinepart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.a08springbootheadlinepart.model.po.Type;
import com.wggglggg.a08springbootheadlinepart.service.TypeService;
import com.wggglggg.a08springbootheadlinepart.mapper.TypeMapper;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wggglggg
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-09-20 11:17:23
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询全部类别信息
     * @return
     */
    @Override
    public List<Type> findAllTypes() {
        List<Type> types = typeMapper.selectList(null);

        return types;
    }
}




