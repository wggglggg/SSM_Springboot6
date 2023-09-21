package com.wggglggg.springbootbase05mybatis.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * ClassName: LogAdvice
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/17 22:18
 * @Version 1.0
 */
@Component
@Aspect
public class LogAdvice {

    @Before("execution(* com.wggglggg.springbootbase05mybatis.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        System.out.println(className +"::"+ simpleName +"::"+ methodName + "开始执行了！");
    }
}
