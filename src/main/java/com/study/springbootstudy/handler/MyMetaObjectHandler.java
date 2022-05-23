package com.study.springbootstudy.handler;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-study
 * @description: 自动填充处理类
 * @author: ZhouFan
 * @create: 2022-05-24 01:09
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdTime", DateUtil.date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifiedTime", DateUtil.date(), metaObject);

    }
}
