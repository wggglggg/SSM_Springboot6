package com.wggglggg.mybatisplus04wapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.mybatisplus04wapper.mapper.UserMapper;
import com.wggglggg.mybatisplus04wapper.model.po.User;
import com.wggglggg.mybatisplus04wapper.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 10:21
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
