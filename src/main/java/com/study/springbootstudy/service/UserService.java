package com.study.springbootstudy.service;

import com.study.springbootstudy.model.User;

import java.util.List;

/**
 * @program: springboot-study
 * @description: user
 * @author: ZhouFan
 * @create: 2022-05-06 23:43
 **/
public interface UserService {

    List<User> queryAllUser();
}
