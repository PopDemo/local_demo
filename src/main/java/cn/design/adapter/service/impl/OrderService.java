package cn.design.adapter.service.impl;

import cn.design.adapter.service.AdapterOrderService;

import java.util.logging.Logger;

public class OrderService implements AdapterOrderService {


    @Override
    public boolean getFirstOrderByid(String id) {
        System.out.println("外部请求");
        return true;
    }


}
