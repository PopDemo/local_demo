package cn.design.adapter.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderMQ {

    private String uid; // ⽤户ID
    private String sku; // 商品
    private String orderId; // 订单ID
    private Date createOrderTime; // 下单时间


}
