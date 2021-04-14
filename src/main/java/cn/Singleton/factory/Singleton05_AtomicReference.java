package cn.Singleton.factory;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference原子类 单例模式
 */
public class Singleton05_AtomicReference {

    /**
     * 将instance放入原子类 AtominReference 中进行保证安全问题
     */
    private static final AtomicReference<Singleton05_AtomicReference> INSTANCE = new AtomicReference<Singleton05_AtomicReference>();


    private Singleton05_AtomicReference(){

    }

    /**
     *
     *  INSTANCE.compareAndSet
     *  fix: 通过 compareAndSer 达到CAS的问题
     *
     *  解决的问题:
     *   1. 使用原子类的话比synchronized耗费的资源小很多
     *   2. 同时又能 直接到 cas 阶段
     *
     *
     * @return
     */
    public static final Singleton05_AtomicReference getInstance(){
        for ( ; ; ){
            Singleton05_AtomicReference instance = INSTANCE.get();
            if (null != instance) return  instance;

            INSTANCE.compareAndSet(null,new Singleton05_AtomicReference());

            return INSTANCE.get();
        }
    }


}
