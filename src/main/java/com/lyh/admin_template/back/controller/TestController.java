package com.lyh.admin_template.back.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyh.admin_template.back.common.exception.GlobalException;
import com.lyh.admin_template.back.common.utils.ExceptionUtil;
import com.lyh.admin_template.back.common.utils.MessageSourceUtil;
import com.lyh.admin_template.back.common.utils.Result;
import com.lyh.admin_template.back.common.validator.group.AddGroup;
import com.lyh.admin_template.back.common.validator.group.UpdateGroup;
import com.lyh.admin_template.back.entity.User;
import com.lyh.admin_template.back.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private MessageSourceUtil messageSourceUtil;
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
    @ApiOperation(value = "测试分页插件")
    @GetMapping("/testMyBatisPlus/page/{current}/{size}")
    public Result testPage(@PathVariable("current") Long current, @PathVariable("size") Long size) {
        Page<User> page = new Page(current, size);
        return Result.ok(true,200,"分页成功").data("page", userService.page(page, null));
    }

    @ApiOperation(value = "测试 JSR 303 添加时的校验规则")
    @PostMapping("testValidator/save")
    public Result testValidatorSave(@Validated({AddGroup.class}) @RequestBody User user) {
        if(userService.save(user)) {
            return Result.ok(true,200,"添加成功").message("数据添加成功");
        }
        return Result.error().message("数据添加失败");
    }

    @ApiOperation(value = "测试 JSR 303 更新时的校验规则")
    @PostMapping("testValidator/update")
    public Result testValidatorUpdate(@Validated({UpdateGroup.class}) @RequestBody User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", user.getName());
        if(userService.update(user, updateWrapper)) {
            return Result.ok(true,200,"更新成功").message("数据更新成功");
        }
        return Result.error().message("数据更新失败");
    }

    @ApiOperation(value = "测试国际化返回数据")
    @GetMapping("/testLocale")
    public Result testI18n() {
        return Result.ok(true,200,"国际化").data("test", messageSourceUtil.getMessage("test"));
    }
}
