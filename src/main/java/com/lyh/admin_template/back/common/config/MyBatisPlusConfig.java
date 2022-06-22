package com.lyh.admin_template.back.common.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: back
 * @description: 444
 * @packagename: com.lyh.admin_template.back.common.config
 * @author: 姚泽宇
 * @date: 2022-06-22 08:09
 **/
@Configuration
@MapperScan("com.lyh.admin_template.back.mapper")
public class MyBatisPlusConfig {
    /**
     * 分页插件
     * @return 分页插件的实例
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁插件
     * @return 乐观锁插件的实例
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
