package com.lyh.admin_template.back.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: back
 * @description: 34
 * @packagename: com.lyh.admin_template.back.handler
 * @author: 姚泽宇
 * @date: 2022-06-21 22:10
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的填充规则
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "deleteFlag", Integer.class, 0);
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
    }

    /**
     * 更新时的填充规则
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
