package cn.bridging.pay;

import cn.bridging.pay.paymodel.impl.FingerPayType;
import cn.bridging.pay.paymodel.impl.pwdPayType;
import cn.bridging.pay.paytype.ZFBPay;
import cn.bridging.pay.paytype.wechatPay;

import javax.xml.crypto.dsig.spec.XPathType;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Paytest {

    public static void main(String[] args) {
        Pay wechat = new wechatPay(new FingerPayType());
        wechat.transfer("11","明哥",new BigDecimal(111.11));

        Pay zfbPay = new ZFBPay(new pwdPayType());
        zfbPay.transfer("22","popdemo",new BigDecimal(11.11));





    }


}
