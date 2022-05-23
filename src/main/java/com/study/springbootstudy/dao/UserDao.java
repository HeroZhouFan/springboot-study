package com.study.springbootstudy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springbootstudy.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: springboot-study
 * @description: 用户
 * @author: ZhouFan
 * @create: 2022-05-06 23:41
 **/
@Mapper
public interface UserDao extends BaseMapper<User> {

}
