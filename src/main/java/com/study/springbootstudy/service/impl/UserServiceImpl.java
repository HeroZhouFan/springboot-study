package com.study.springbootstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springbootstudy.dao.UserDao;
import com.study.springbootstudy.model.User;
import com.study.springbootstudy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-study
 * @description: user
 * @author: ZhouFan
 * @create: 2022-05-06 23:44
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

}
