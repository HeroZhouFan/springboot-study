package com.study.springbootstudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springbootstudy.dao.LoggerDao;
import com.study.springbootstudy.model.Logger;
import com.study.springbootstudy.service.LoggerService;
import org.springframework.stereotype.Service;

/**
 * 日志(Logger)表服务实现类
 *
 * @author makejava
 * @since 2022-05-22 12:24:11
 */
@Service
public class LoggerServiceImpl extends ServiceImpl<LoggerDao, Logger> implements LoggerService {

}