package com.example.demo.support;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: xiaolong.chang
 * @Date: 2021/4/10
 * @Description:
 */
public class SnowFlakeEnableCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String value = context.getEnvironment().getProperty("snowflake.enable");
        return "true".equalsIgnoreCase(value);
    }

}
