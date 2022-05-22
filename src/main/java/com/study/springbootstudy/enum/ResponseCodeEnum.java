package com.study.springbootstudy;

/**
 * 该类表示业务错误
 *
 * @author caryfankai
 * @date 2021-09-17
 */
public enum ResponseCodeEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 认证失败
     */
    ERROR_AUTH(9101, "auth failure"),

    /**
     * 内部错误
     */
    ERROR_INTERNAL(9102, "internal server error"),

    /**
     * 数据格式错误
     */
    ERROR_DATA_FORMAT(9103, "error data format"),

    /**
     * 数据取值不合法
     */
    ERROR_DATA_RESTRICTION(9104, "error data value"),
    /**
     * 入参错误
     */
    ERROR_DATA_INCOMPLETE(9105, "error data null"),
    /**
     * 权限不足
     */
    ERROR_INSUFFICIENT_PERMISSIONS(9106, "error insufficient permissions"),
    /**
     * 自动化只选择3,测试提bug要改成中文提示
     */
    ERROR_TASK_ERROR(9107, "评测不能单独选中"),
    /**
     * 需要先保存场景
     */
    ERROR_SCENEID_NULL(9108, "需要先保存场景"),
    /**
     * 操作太频繁
     */
    ERROR_OPERATION_TOO_FREQUENTLY(9112, "operation too frequently"),

    /**
     * 脚本执行错误
     */
    ERROR_SCRIPT_EXEC(9113, "script exec erro");

    private static final ResponseCodeEnum[] ERRORS = ResponseCodeEnum.values();

    private final int code;
    private final String message;

    public String getMessage() {
        return message;
    }

    ResponseCodeEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public static ResponseCodeEnum valueOf(int code) {
        for (ResponseCodeEnum error : ERRORS) {
            if (error.code == code) {
                return error;
            }
        }
        return ResponseCodeEnum.ERROR_INTERNAL;
    }

}
