package cn.design.adapter.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class POPOrderDelivered {

    private String uId; // ⽤户ID
    private String orderId; // 订单号
    private Date orderTime; // 下单时间
    private Date sku; // 商品
    private Date skuName; // 商品名称
    private BigDecimal decimal; // ⾦额

}
