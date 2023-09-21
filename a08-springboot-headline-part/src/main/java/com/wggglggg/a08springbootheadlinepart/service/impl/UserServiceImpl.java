package com.wggglggg.a08springbootheadlinepart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.a08springbootheadlinepart.mapper.UserMapper;
import com.wggglggg.a08springbootheadlinepart.model.po.User;
import com.wggglggg.a08springbootheadlinepart.service.UserService;
import com.wggglggg.a08springbootheadlinepart.utils.JwtHelper;
import com.wggglggg.a08springbootheadlinepart.utils.MD5Util;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import com.wggglggg.a08springbootheadlinepart.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author wggglggg
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2023-09-20 09:37:12
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     /**
     * 登录业务
     *
     *   1.根据账号，查询用户对象  - loginUser
     *   2.如果用户对象为null，查询失败，账号错误！ 501
     *   3.对比，密码 ，失败 返回503的错误
     *   4.根据用户id生成一个token, token -> result 返回
     * @param user
     * @return
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        //根据账号查询数据
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());

        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

//        boolean present = Optional.ofNullable(loginUser).isPresent();
        if (loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //对比密码
        if (StringUtils.hasLength(user.getUserPwd()) &&
            MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            //登录成功
            //根据用户id生成 token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            //将token封装到result返回
            Map<String, String> data = new HashMap<>();
            data.put("token", token);

            return Result.ok(data);
        }
        //密码错误
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);

    }

    /**
     * 根据token获取用户数据
     *
     *  1. token是否在有效期
     *  2. 根据token解析userId
     *  3. 根据用户id查询用数据
     *  4. 去掉密码，封装result结果返回即可
     *
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        //是否过期 true过期
        boolean expiration = jwtHelper.isExpiration(token);

        if (expiration){        //失效，未登录看待
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        Long userId = jwtHelper.getUserId(token);

        User user = userMapper.selectById(userId);
        if (user != null){
            user.setUserPwd("");
            HashMap<Object, Object> data = new HashMap<>();
            data.put("loginUser", user);

            return Result.ok(data);

        }
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }

    /**
     * 检查账号是否可以注册
     *
     * @param username 账号信息
     * @return
     */
    @Override
    public Result checkUserName(String username) {

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(lambdaQueryWrapper);

        if (user != null){  // 数据库有同名人存在，返回错误信息
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        return Result.ok(null);
    }

    /**
     * url地址：user/regist
     * 请求方式：POST
     * 请求参数：
     * {
     *     "username":"zhangsan",
     *     "userPwd":"123456",
     *     "nickName":"张三"
     * }
     * 响应数据：
     * {
     *    "code":"200",
     *    "message":"success"
     *    "data":{}
     * }
     *
     * 实现步骤:
     *   1. 将密码加密
     *   2. 将数据插入
     *   3. 判断结果,成 返回200 失败 505
     */
    @Override
    public Result register(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());

        Long count = userMapper.selectCount(lambdaQueryWrapper);

        if (count > 0){
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));

        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);

        return Result.ok(null);
    }
}




