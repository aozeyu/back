package com.lyh.admin_template.back.controller;

import com.lyh.admin_template.back.common.exception.GlobalException;
import com.lyh.admin_template.back.common.utils.ExceptionUtil;
import com.lyh.admin_template.back.common.utils.Result;
import com.lyh.admin_template.back.entity.User;
import com.lyh.admin_template.back.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    @Autowired
    private UserService userService;
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getListOfUser")
    public Result testGetListOfUser() {
        return Result.ok(true,200,"请求成功").data("user", userService.list());
    }

    @ApiOperation(value = "测试 MyBatis Plus 自动填充数据功能")
    @PostMapping("/testMyBatisPlus/AutoFill")
    public Result testMyBatisPlusAutoFill(@RequestBody User user) {
        if(userService.save(user)) {
            return Result.ok(true,200,"成功").message("数据添加成功");
        }
        return Result.error().message("数据添加失败");
    }
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

    @ApiOperation(value = "删除指定姓名的用户")
    @DeleteMapping("/testMyBatisPlus/LogicDel")
    public Result testMyBatisPlusLogicDel(@RequestParam String name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        userService.removeByMap(hashMap);
        return Result.ok(true,200,"删除成功");
    }

}
