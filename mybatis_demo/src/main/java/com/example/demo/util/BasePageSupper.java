package com.example.demo.util;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus的分页插件  PaginationInterceptor
 */
@Configuration
@MapperScan("com.example.demo.service.*")
public class BasePageSupper {


    // mybatis-plus paginationInterceptor分页器
//    public PaginationInterceptor paginationInterceptor(){
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setLocalPage()
//    }

}
