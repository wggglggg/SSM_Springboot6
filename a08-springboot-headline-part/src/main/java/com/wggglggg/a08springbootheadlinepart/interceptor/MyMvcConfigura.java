package com.wggglggg.a08springbootheadlinepart.interceptor;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MyInterceptor
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/20 9:02
 * @Version 1.0
 */
//@Configuration
@Configuration
public class MyMvcConfigura implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 将第三方的拦截器加入进来
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){

        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        //分页
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //乐观锁
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //防全局修改和删除
        mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());


        return mybatisPlusInterceptor;
    }

    // 注册自定义的LoginInterceptor拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/headline/**");
        System.out.println("registry = loginInterceptor");

    }
}
