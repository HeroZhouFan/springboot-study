package com.study.springbootstudy.exception;

import com.study.springbootstudy.common.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 业务异常处理类
 *
 * @author v_merzhang
 * @since 2021/6/23 17:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {
    private Integer code;
    private String msg;

    public ServiceException(Integer code, String msg) {
        super(msg);
        if (ResponseCode.PARAMETER_IS_NULL == code) {
            msg = "参数" + msg + "为空！";
        }
        this.code = code;
        this.msg = msg;
    }

}
