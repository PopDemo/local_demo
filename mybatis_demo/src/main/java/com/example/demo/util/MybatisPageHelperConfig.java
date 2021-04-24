package com.example.demo.util;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisPageHelperConfig {
    /**
     * com.github.pagehelper  导入包
     * 为
     * @return
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        // 使用方言的分页
        p.setProperty("helperDialect", "mysql");
        p.setProperty("pageSizeZero", "mysql");
        pageHelper.setProperties(p);

        return pageHelper;
    }


}
