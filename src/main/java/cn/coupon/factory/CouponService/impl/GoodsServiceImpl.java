package cn.coupon.factory.CouponService.impl;

import cn.coupon.factory.CouponService.CommodityService;

public class GoodsServiceImpl implements CommodityService {
    @Override
    public void SendCommodity(String uid, String commodityId) {
        System.out.println("进行对uid:"+uid+"进行发送商品,商品Id为："+commodityId);
    }
}
