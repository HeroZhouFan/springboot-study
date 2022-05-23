package com.study.springbootstudy.controller;

import com.study.springbootstudy.model.User;
import com.study.springbootstudy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springboot-study
 * @description: user
 * @author: ZhouFan
 * @create: 2022-05-06 23:45
 **/
@RestController
@RequestMapping("/user")
@Api("用户管理接口")
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "查看所有用户")
    @ApiOperation("查看所有用户")
    @GetMapping("/queryAllUser")
    public List<User> queryAllUser(){
        return userService.list();
    }

}
