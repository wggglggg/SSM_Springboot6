package com.wggglggg.a08springbootheadlinepart;

import com.wggglggg.a08springbootheadlinepart.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class A08SpringbootHeadlinePartApplicationTests {

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    void test() {
        //生成 传入用户标识
        String token = jwtHelper.createToken(1l);
        System.out.println("token = " + token);

        //解析用户标识  long 转成 ｉｎｔ
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);

        //校验是否到期! false 未到期 true到期
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);


    }

}
