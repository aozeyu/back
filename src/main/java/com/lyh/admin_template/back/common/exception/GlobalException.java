package com.lyh.admin_template.back.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.http.HttpStatus;

/**
 * @program: back
 * @description: 444
 * @packagename: com.lyh.admin_template.back.common.exception
 * @author: 姚泽宇
 * @date: 2022-06-21 21:23
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends RuntimeException{

    private String message;

    /**
     * 保存响应状态码
     */
    private Integer code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    /**
     * 默认构造方法，根据异常信息 构建一个异常实例对象
     * @param message 异常信息
     */
    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * 根据异常信息、响应状态码构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     */
    public GlobalException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
    /**
     * 根据异常信息，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param e 异常对象
     */
    public GlobalException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }
    /**
     * 根据异常信息，响应状态码，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     * @param e 异常对象
     */
    public GlobalException(String message, Integer code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }
}
