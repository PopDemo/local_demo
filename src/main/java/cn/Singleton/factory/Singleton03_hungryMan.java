package cn.Singleton.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 饿汉模式  -> 单例模式
 */
public class Singleton03_hungryMan {

    /**
     * 饿汉模式 hungryMan
     * fix:
     *    1. 饿汉字面含义： 本身就进行在等待 所以提前创建号的instance
     */
    private static  Singleton03_hungryMan instance = new Singleton03_hungryMan();

    private Singleton03_hungryMan(){

    }

    public static Singleton03_hungryMan getInstance(){
        return instance;

    }


}
