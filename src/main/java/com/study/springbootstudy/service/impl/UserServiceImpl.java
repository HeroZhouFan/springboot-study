package com.study.springbootstudy.service.impl;

import com.study.springbootstudy.dao.UserDao;
import com.study.springbootstudy.model.User;
import com.study.springbootstudy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springboot-study
 * @description: user
 * @author: ZhouFan
 * @create: 2022-05-06 23:44
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        return userDao.selectList(null);
    }
}
