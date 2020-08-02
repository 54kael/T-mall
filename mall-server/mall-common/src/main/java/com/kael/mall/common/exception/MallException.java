package com.kael.mall.common.exception;

import com.kael.mall.common.api.Statue;

/**
 * 自定义异常
 */
public class MallException extends RuntimeException {
    private final Statue statue;

    public MallException(Statue statue) {
        this.statue = statue;
    }

    @Override
    public String getMessage() {
        return this.statue.getMessage();
    }

    public Statue getStatue() {
        return statue;
    }
}
