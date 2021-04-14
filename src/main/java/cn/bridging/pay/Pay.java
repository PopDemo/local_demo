package cn.bridging.pay;

import cn.bridging.pay.paymodel.IpayModel;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.logging.Logger;

public abstract class Pay {

    protected IpayModel payModel;

    public Pay(IpayModel payModel){
        this.payModel = payModel;
    }


    public abstract String transfer(String uid,String tardeId, BigDecimal amount);


}
