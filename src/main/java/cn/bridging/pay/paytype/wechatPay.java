package cn.bridging.pay.paytype;

import cn.bridging.pay.Pay;
import cn.bridging.pay.paymodel.IpayModel;

import java.math.BigDecimal;

public class wechatPay extends Pay {

    public wechatPay(IpayModel payModel) {
        super(payModel);
    }

    @Override
    public String transfer(String uid, String tardeId, BigDecimal amount) {
        System.out.println("开始模拟微信渠道支付划账开始：uid"+uid);
        boolean security = payModel.security(uid);

        if (!security){
            System.out.println("模拟微信渠道支付划账拦截 uid："+uid);
            return "00011";
        }
        System.out.println("模拟微信渠道支付划账成功 uid："+uid);

        return "00000";
    }
}
