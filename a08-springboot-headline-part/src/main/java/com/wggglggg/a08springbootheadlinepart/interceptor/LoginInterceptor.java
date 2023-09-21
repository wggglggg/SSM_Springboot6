package com.wggglggg.a08springbootheadlinepart.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wggglggg.a08springbootheadlinepart.utils.JwtHelper;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import com.wggglggg.a08springbootheadlinepart.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: LoginInterceptor
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/21 9:23
 * @Version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (jwtHelper.isExpiration(token)){  // true 代表过期了
            Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);

            // 由于无法返回Result，所以要借用ObjectMapp, jackson集成一个返回json的方法
            ObjectMapper objectMapper = new ObjectMapper();
            // 将json转成了 string
            String json = objectMapper.writeValueAsString(result);
            // 响应写给客户端
            response.getWriter().print(json);

            //拦截,
            return false;
        }

        //放行
        return true;
    }
}
