package com.study.springbootstudy.common;

import cn.hutool.core.io.IORuntimeException;
import com.study.springbootstudy.model.Result;
import com.study.springbootstudy.exception.MyFileNotFoundException;
import com.study.springbootstudy.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.stream.Collectors;

import static com.study.springbootstudy.common.ResponseCode.*;

/**
 * 全局异常控制
 * @author v_merzhang
 * @since 2021/6/23 17:16
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    /**
     * 业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    public Result<String> serviceException(ServiceException e) {
        log.error("系统异常:", e);
        return new Result<>(e.getCode(), e.getMsg());
    }

    /**
     * 处理入参异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<String> handleIllegalParamException(MethodArgumentNotValidException e) {
        String message = "参数格式校验失败";
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        if (errors.size() > 0) {
            message = errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(","));
        }
        log.error("系统异常:", e);
        return new Result<>(PARAMETER_IS_FAILURE, message);
    }

    /**
     * 请求参数类型转换异常
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result<String> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("系统异常:", e);
        return new Result<>(PARAMETER_IS_FAILURE, e.getMessage());
    }

    /**
     * 文件不存在异常
     */
    @ExceptionHandler(value = {MyFileNotFoundException.class, IORuntimeException.class, NoSuchFileException.class})
    public Result<String> myFileNotFoundException(Exception e) {
        log.error("系统异常:", e);
        return new Result<>(FILE_NOTFOUND, e.getMessage());
    }

    /**
     * 其他类型的异常
     */
    @ExceptionHandler(value = Exception.class)
    public Result<String> handle(Exception e) {
        log.error("系统异常:", e);
        return new Result<>(FAIL_CODE, "系统异常，请联系管理员");
    }

}
