package cn.redis.adapter.Cache;

import cn.redis.adapter.service.CacheService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {


    /**
     * 1.入参解析
     *  interfaceClass
     *  主要是为了指定动态代理后需要获取的方法（这也就是为什么两个redis模式去实现同一个接口的作用）
     *
     * @param interfaceClass
     * @param cacheAdapter
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getProxy(Class<T> interfaceClass, CacheService
            cacheAdapter) throws Exception {
        /**
         * 最重要的
         *     通过动态代理的方式，进行获取对应的redis实例，动态的代理（获取）到对应的method
         */
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
//        加载被代理的类
        ClassLoader classLoader =
                Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]},
                handler);
//        throw new RuntimeException("show time...");
    }
}
