package com.wggglggg.mybatisplus04wapper.interceptor;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyInterceptor
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 15:15
 * @Version 1.0
 */
@Component
public class MyInterceptor{

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //mybatis-plus的插件集合 【加入到这个集合中即可，分页插件，乐观锁插件】
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //乐观锁【版本号插件】 mybatis-plus会在更新的时候，每次帮我们对比版本号字段和增加版本号+1
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
