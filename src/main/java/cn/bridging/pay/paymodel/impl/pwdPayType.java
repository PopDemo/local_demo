package cn.bridging.pay.paymodel.impl;

import cn.bridging.pay.paymodel.IpayModel;

public class pwdPayType implements IpayModel {
    @Override
    public boolean security(String uid) {
        System.out.println("使用密码进行风控环境支付");
        return true;
    }
}
