package com.study.springbootstudy.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 日志(Logger)实体类
 *
 * @author makejava
 * @since 2022-05-22 12:24:09
 */
@Data
public class Logger implements Serializable {
    private static final long serialVersionUID = 183295012172429072L;
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 客户端请求IP
    */
    private String clientIp;
    /**
    * 请求路径
    */
    private String uri;
    /**
    * 终端请求方式（普通请求， ajax）
    */
    private String type;
    /**
    * 请求方式（get,post）
    */
    private String method;
    /**
    * 请求数据
    */
    private String paramData;
    /**
    * 用户标识
    */
    private String userId;
    /**
    * 请求时间
    */
    private Date time;
    /**
    * 响应时间
    */
    private Date returnTime;
    /**
    * 响应数据
    */
    private String returnData;
    /**
    * http响应码
    */
    private String httpStatusCode;
    /**
    * 服务器响应码
    */
    private String systemStatusCode;
    /**
    * 响应耗时
    */
    private Integer timeConsuming;
    /**
    * 异常信息
    */
    private String error;
    /**
    * cookie
    */
    private String cookie;
    /**
    * 是否有效 1：有效 0：无效
    */
    private Integer isValid;

    @TableField(fill= FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill= FieldFill.UPDATE)
    private Date modifiedTime;

}