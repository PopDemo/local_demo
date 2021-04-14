package cn.design.adapter;

import cn.design.adapter.to.RebateInfo;
import com.alibaba.fastjson.JSON;
import java.util.Map;

public class MQAdapter {
    /**
     * 最重要的是
     * 1. 通过反射的方式 去拿到 属性map中系统所需的set方法 进行把多元化set到系统中
     * @param strJson
     * @param link
     * @return
     * @throws Exception
     */

    public static RebateInfo filter(String strJson,Map<String,String> link) throws Exception{
        return filter(JSON.parseObject(strJson,Map.class),link);
    }



    public static RebateInfo filter(Map obj,Map<String,String> link) throws Exception{
        RebateInfo rebateInfo = new RebateInfo();
        //
        for (String key:link.keySet()) {
            //link.put("系统中台所需属性","MQ中的消息属性")
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set"+key.substring(0,1).
                    toUpperCase()+key.substring(1),String.class).invoke(rebateInfo,val.toString());
        }
        return rebateInfo;
    }

}
