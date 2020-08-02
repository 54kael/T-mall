package com.kael.mall.common.exception;

import com.kael.mall.common.api.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    /**
     * 拦截自定义异常
     * @param e 自定义异常
     */
    @ExceptionHandler(value = MallException.class)
    public Result handle(MallException e) {
        return Result.failure(e.getStatue());
    }
}
