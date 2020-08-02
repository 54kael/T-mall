package com.kael.mall.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private String code;
    private String message;
    private Map<String,Object> data;
    private Result(Statue statue){
        this.setCode(statue.getCode());
        this.setMessage(statue.getMessage());
    }

    /**
     * 操作成功，不需要返回数据
     */
    public static Result ok() {
        return new Result(Statue.SUCCESS);
    }

    /**
     * 操作成功，并且给data单独设置属性名和值
     * @param attr (data属性名)
     * @param o (data数据)
     */
    public Result data(String attr, Object o) {
        Map<String,Object> map = new HashMap<>();
        map.put(attr,o);
        setData(map);
        return this;
    }

    /**
     * 操作成功，一次性返回data
     * @param map data
     */
    public Result data(Map<String,Object> map) {
        setData(map);
        return this;
    }

    /**
     * 操作失败
     * @param statue (失败状态码)
     */
    public static Result failure(Statue statue) {
        return new Result(statue);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    private void setData(Map<String, Object> data) {
        this.data = data;
    }
}
