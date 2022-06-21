package com.lyh.admin_template.back.common.utils;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: back
 * @description: 444
 * @packagename: com.lyh.admin_template.back.common.utils
 * @author: 姚泽宇
 * @date: 2022-06-21 21:06
 **/
@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private Result() {

    }
    private Result(String message,Integer code, Boolean success){
        this.message = message;
        this.code = code;
        this.success = success;
    }
    public static Result ok(Boolean success,Integer code,String message) {
        return new Result(message, code, success);
    }

    public static Result error() {
        return new Result("error", HttpStatus.SC_INTERNAL_SERVER_ERROR, false);
    }

    /**
     * 返回一个自定义 失败操作 的结果
     * @param success 响应是否成功
     * @param code 响应状态码
     * @param message 相应消息
     * @return 失败操作的实例对象
     */
    public static Result error(Boolean success, Integer code, String message) {
        return new Result(message, code, success);
    }



    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.data.putAll(map);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
