package com.lyh.admin_template.back.controller;

import com.lyh.admin_template.back.common.exception.GlobalException;
import com.lyh.admin_template.back.common.utils.ExceptionUtil;
import com.lyh.admin_template.back.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: back
 * @description: 444
 * @packagename: com.lyh.admin_template.back
 * @author: 姚泽宇
 * @date: 2022-06-21 21:15
 **/
@RestController
@RequestMapping("/test")
@Api(tags = "测试页面")
public class TestController {
    @GetMapping("/testResult")
    public Result testResult() {
        return Result.ok(true,200,"成工");
    }
    @GetMapping("/testGlobalException")
    public Result testGlobalException() {
        try {
            int test = 10 / 0;

        }catch (Exception e) {
            throw new GlobalException(ExceptionUtil.getMessage(e));
        }
        return Result.ok(true,200,"冲高");
    }

    @ApiOperation(value = "测试swagger")
    @GetMapping("/testSwagger")
    public Result testSwagger(){
        return Result.ok(true,200,"嗨咯");
    }
}
