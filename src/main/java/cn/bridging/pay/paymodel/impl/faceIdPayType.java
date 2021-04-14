package cn.bridging.pay.paymodel.impl;

import cn.bridging.pay.paymodel.IpayModel;

public class faceIdPayType implements IpayModel {
    @Override
    public boolean security(String uid) {
        System.out.println("使用面容进行风控支付");
        return true;
    }
}
