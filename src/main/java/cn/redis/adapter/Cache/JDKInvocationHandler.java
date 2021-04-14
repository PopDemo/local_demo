package cn.redis.adapter.Cache;

import cn.redis.adapter.service.CacheService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {
    private CacheService cacheAdapter;
    public JDKInvocationHandler(CacheService cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    /**
     *1.入参说明
     *  proxy:　　指代我们所代理的那个真实对象
     *  method:　　指代的是我们所要调用真实对象的某个方法的Method对象
     *  args:　　指代的是调用真实对象某个方法时接受的参数
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return CacheService.class.getMethod(method.getName(),
//                ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);

        throw new RuntimeException("show Time you");
    }
}