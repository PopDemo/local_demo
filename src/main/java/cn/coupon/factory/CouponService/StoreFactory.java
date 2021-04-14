package cn.coupon.factory.CouponService;

import cn.coupon.factory.CouponService.impl.CouponServiceImpl;
import cn.coupon.factory.CouponService.impl.GoodsServiceImpl;

public class StoreFactory {

    /**
     * 1.这才是工厂模式的重点
     * 2.通过该类获取相对的奖励类
     * @param commodityType
     * @return
     */
    public CommodityService getCommodityTypeClass(Integer commodityType){
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponServiceImpl();
        if (2 == commodityType) return new GoodsServiceImpl();
        throw  new RuntimeException("找不对应的奖励类型");
    }



}
