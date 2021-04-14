package cn.bridging.pay.paymodel.impl;

import cn.bridging.pay.paymodel.IpayModel;

public class FingerPayType implements IpayModel {
    @Override
    public boolean security(String uid) {
        System.out.println("使用指纹进行风控支付");
        return true;
    }
}
