package com.example.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class staticAutoWiredBeanFiled {


    public static man  man;


    /**
     * 静态方法注入bean
     *
     * 例如：
     *  1. static中的man 需要通过某个类中的Method进行返回并注入
     * @param manTo
     */
    @Autowired
    public void satManClass(man manTo){
        this.man = manTo;
    }




}
