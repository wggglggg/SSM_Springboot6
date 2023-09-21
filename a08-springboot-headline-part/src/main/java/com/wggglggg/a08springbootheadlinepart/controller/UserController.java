package com.wggglggg.a08springbootheadlinepart.controller;

import com.wggglggg.a08springbootheadlinepart.model.po.User;
import com.wggglggg.a08springbootheadlinepart.service.UserService;
import com.wggglggg.a08springbootheadlinepart.utils.JwtHelper;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import com.wggglggg.a08springbootheadlinepart.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/20 10:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin        // 跨域访问
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public Result login(@RequestBody User user){

        Result result = userService.login(user);

        return  result;
    }

    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader String token){

        Result result = userService.getUserInfo(token);
        return result;
    }

    /**
     * url地址：user/checkUserName
     * 请求方式：POST
     * 请求参数：param形式
     * username=zhangsan
     * 响应数据:
     * {
     *    "code":"200",
     *    "message":"success"
     *    "data":{}
     * }
     *
     * 实现步骤:
     *   1. 获取账号数据
     *   2. 根据账号进行数据库查询
     *   3. 结果封装
     */
    @PostMapping("/checkUserName")
    public Result checkUserName(String username){

        Result result = userService.checkUserName(username);

        return result;
    }

    @PostMapping("/regist")
    public Result register(@RequestBody User user){
        Result result = userService.register(user);

        return result;
    }

    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestHeader String token){
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration){
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        return Result.ok(null);
    }
}
