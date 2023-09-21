package com.wggglggg.mybatisplus04wapper.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.mybatisplus04wapper.generator.domain.User;
import com.wggglggg.mybatisplus04wapper.generator.mapper.UserMapper;
import com.wggglggg.mybatisplus04wapper.generator.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author wggglggg
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-19 21:28:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}




