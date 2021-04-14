package cn.Singleton.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * lazy man模式  -> 单例模式
 * 本 instance 不具有相关的
 */
public class Singleton02_lazyMan {

    private static Singleton02_lazyMan instance;

    private Singleton02_lazyMan(){

    }


    /**
     * 没有该实例则进行新增
     * lazy man instance
     *
     * 会造成的error:
     *  1. 在进行多线程多个访问者去进行getinstance的时候,会造成相关的
     * @return
     */
    public static Singleton02_lazyMan getinstance(){
        if (null != instance) return instance;
        instance = new Singleton02_lazyMan();
        return instance;
    }





}
