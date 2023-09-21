package com.wggglggg.mybatisplus03curdservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.mybatisplus03curdservice.mapper.UserMapper;
import com.wggglggg.mybatisplus03curdservice.model.po.User;
import com.wggglggg.mybatisplus03curdservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/19 9:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
