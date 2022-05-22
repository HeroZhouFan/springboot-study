package com.study.springbootstudy.service.impl;

import com.study.springbootstudy.dao.LoggerDao;
import com.study.springbootstudy.model.Logger;
import com.study.springbootstudy.service.LoggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志(Logger)表服务实现类
 *
 * @author makejava
 * @since 2022-05-22 12:24:11
 */
@Service
public class LoggerServiceImpl implements LoggerService {
    @Resource
    private LoggerDao loggerDao;

    @Override
    public Integer insert(Logger logger){
        return loggerDao.insert(logger);
    }

    @Override
    public List<Logger> queryAll() {
        return loggerDao.selectList(null);
    }
}