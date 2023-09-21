package com.wggglggg.springbootbase05mybatis.config;

import com.wggglggg.springbootbase05mybatis.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: MyConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 20:10
 * @Version 1.0
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
