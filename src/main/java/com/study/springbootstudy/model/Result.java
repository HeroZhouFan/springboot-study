package com.study.springbootstudy.model;

import com.study.springbootstudy.ResponseCodeEnum;
import com.study.springbootstudy.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.study.springbootstudy.common.ResponseCode.FAIL_CODE;
import static com.study.springbootstudy.common.ResponseCode.SUCCESS_CODE;


/**
 * @author zhoufan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {


    public static final long serialVersionUID = 42L;

    private Integer code;
    private String message;
    private T data;


    public static final Result<String> SUCCESS = new Result<String>(null);
    public static final Result<String> FAIL = new Result<String>(FAIL_CODE, null);

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

    /**
     * 设置data
     * @param data
     * @return ResDto
     */
    public Result<T> setBody(T data) {
        this.data = data;
        return this;
    }

    /**
     * 创建成功返回ResDto
     * @param data 返回数据实体
     * @param <T>
     * @return
     */
    public static <T> Result<T> createSuccess(T data) {
        Result<T> resp = new Result<>();
        resp.setCode(ResponseCodeEnum.SUCCESS.getCode());
        resp.setMessage(ResponseCodeEnum.SUCCESS.getMessage());
        return resp.setBody(data);
    }

    /**
     * 创建成功返回ResDto
     * @return ResDto
     */
    public static Result createSuccess() {
        Result resp = new Result();
        resp.setCode(ResponseCodeEnum.SUCCESS.getCode());
        resp.setMessage(ResponseCodeEnum.SUCCESS.getMessage());
        return resp;
    }

    public static Result createError(int code, String message) {
        Result resp = new Result();
        resp.code = code;
        resp.message = message;
        return resp;
    }

    public static Result createError(ResponseCodeEnum responseCode, String extraMessage) {
        Result resp = new Result();
        resp.setCode(responseCode.getCode());
        resp.setMessage(responseCode.getMessage()+ CommonConstants.SYMBOL_COMMA+extraMessage);
        return resp;
    }

    public static Result createInterError() {
        Result resp = new Result();
        resp.setCode(ResponseCodeEnum.ERROR_INTERNAL.getCode());
        resp.setMessage(ResponseCodeEnum.ERROR_INTERNAL.getMessage());
        return resp;
    }


}
