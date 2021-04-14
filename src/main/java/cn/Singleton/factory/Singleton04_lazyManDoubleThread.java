package cn.Singleton.factory;

/**
 * 双线程安全单例模式
 */
public class Singleton04_lazyManDoubleThread {

    private static Singleton04_lazyManDoubleThread instance;

    private Singleton04_lazyManDoubleThread(){

    }

    /**
     * 相当于 -> Singleton02_lazyManSynchronized <- 的doubleThred
     *
     * 1. 双重锁校验   -> 单例模式
     * @return
     */
    public static Singleton04_lazyManDoubleThread getInstance(){
        if (null != instance) return instance;

        synchronized (Singleton04_lazyManDoubleThread.class){
            if (null == instance){
                return new Singleton04_lazyManDoubleThread();
            }
        }

        return instance;
    }


}
