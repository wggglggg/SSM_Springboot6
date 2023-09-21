package com.wggglggg.a08springbootheadlinepart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wggglggg.a08springbootheadlinepart.model.po.User;
import com.wggglggg.a08springbootheadlinepart.utils.Result;

/**
* @author wggglggg
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-09-20 09:37:12
*/
public interface UserService extends IService<User> {

    /**
     * 登陆
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据token获取用户数据
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 从注册页面获取注册用户名，然后与数据库做匹配，是否有同名
     * @param username
     * @return
     */
    Result checkUserName(String username);

    /**
     * 注册业务
     * @param user
     * @return
     */
    Result register(User user);
}
