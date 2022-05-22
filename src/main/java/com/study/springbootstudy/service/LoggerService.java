package com.study.springbootstudy.service;

import com.study.springbootstudy.model.Logger;

import java.util.List;

/**
 * 日志(Logger)表服务接口
 *
 * @author makejava
 * @since 2022-05-22 12:24:11
 */
public interface LoggerService {

    Integer insert(Logger logger);

    List<Logger> queryAll();
}