package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class awareApplication implements ApplicationContextAware {

    private static ApplicationContext application;

    /**
     * ApplicationContextAware
     * 1. 使用可操作bean的Spring容器
     * @param applicationContext
     * @throws BeansException
     */

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.application=applicationContext;
    }

    private static ApplicationContext getApplication(){
        return application;
    }

    private static Object getBean(String bean){

        return  application.getBean(bean);
    }


    private static void checkApplicationContext(){
        if (null == application){
            throw new IllegalStateException("初始化application失败");
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        Map<?, ?> map = application.getBeansOfType(clazz);
        return map.isEmpty() ? null : (T) map.values().iterator().next();
    }
}
