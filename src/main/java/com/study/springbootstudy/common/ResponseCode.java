package com.study.springbootstudy.common;


/**
 * 响应编码
 * @author v_merzhang
 * @since 2021/6/23 17:16
 */
public interface ResponseCode {

    /**
     * 正常
     */
    int SUCCESS_CODE = 0;
    /**
     * 系统异常
     */
    int FAIL_CODE = 500;

    /**
     * 参数格式校验失败
     */
    int PARAMETER_IS_FAILURE = 1001;

    /**
     * 参数为空
     */
    int PARAMETER_IS_NULL = 1002;

    /**
     * 文件不存在
     */
    int FILE_NOTFOUND = 1003;
    /**
     * 参数重复
     */
    int PARAMETER_REPEAT = 1004;
    /**
     * 获取结果为空
     */
    int RESULT_NULL = 1005;
    /**
     * 模板数据为空
     */
    int TEMPLATE_DATA_NULL = 1006;

    /**
     * 身份校验失败
     */
    int IDENTITY_VERISICATION_FAILED = 1007;
}
