package cn.Singleton.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * lazy man instance模式  -> 单例模式
 * 本 instance 是具有线程安全的instance
 */
public class Singleton02_lazyManSynchronized {


    private static Singleton02_lazyManSynchronized instance;


    /**
     * 单体构造
     */
    private Singleton02_lazyManSynchronized(){

    }

    /**
     * lazy man
     * 1.使用synchronized进行保证getinstance时的安全问题
     *
     * 隐性的error:
     *  1. 在进行使用getinstance时，会大量的耗费资源和空间（synchronized的使用后果）
     *
     * @return
     */
    public static synchronized Singleton02_lazyManSynchronized getinstance(){
        if (instance != null) return instance;
        instance = new Singleton02_lazyManSynchronized();
        return instance;
    }





}
