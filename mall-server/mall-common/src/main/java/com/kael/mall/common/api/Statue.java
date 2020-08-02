package com.kael.mall.common.api;

public enum Statue {
    SUCCESS("2000", "操作成功"),
    FAILED("5000", "操作失败"),
    VALIDATE_FAILED("404", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限");
    private final String code;
    private final String message;

    private Statue(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
