package cn.coupon.factory.CouponService;

import org.junit.Test;

public class FactoryApplication {

    @Test
    public void StoreGetCommpodityType(){
        StoreFactory storeFactory = new StoreFactory();

        //奖励  <优惠券>
        CommodityService couponService = storeFactory.getCommodityTypeClass(1);
        couponService.SendCommodity("yfuid","1");


        //奖励  <good>
        CommodityService goodsService = storeFactory.getCommodityTypeClass(2);
        goodsService.SendCommodity("yfuid","01");

    }


}
