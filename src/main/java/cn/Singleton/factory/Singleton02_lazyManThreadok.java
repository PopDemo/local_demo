package cn.Singleton.factory;

/**
 * 通过静态内部类 达到 实现单例模式
 * 同时
 *   1. 不会因为加锁而造成的 资源耗费
 *
 *
 * 这是单例模式最推荐的
 */
public class Singleton02_lazyManThreadok {

    /**
     * ****(核心)
     * 使用静态内部类进行创建instance
     *
     */
    private static class Singleton{
        private static Singleton02_lazyManThreadok instance = new Singleton02_lazyManThreadok();
    }

    private Singleton02_lazyManThreadok(){

    }

    public static Singleton02_lazyManThreadok getInstance(){
        return Singleton.instance;
    }



}
