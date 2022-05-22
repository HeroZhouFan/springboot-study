package com.study.springbootstudy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.springbootstudy.model.Logger;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志(Logger)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-22 12:24:11
 */
@Mapper
public interface LoggerDao extends BaseMapper<Logger> {


}