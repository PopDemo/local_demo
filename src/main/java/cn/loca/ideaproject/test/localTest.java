package cn.loca.ideaproject.test;


import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class localTest {


    /**
     * 本方法是进行测试 线程池的使用 和 newThreadPoolExecutor构造参数
     *     1. 进行解析newThreadPoolExecutor构造参数的入参
     */
    @Test
    public void shouTime(){
        /**
         * corePoolSize 核心线程数量
         * maximumPoolSize  最大线程数量
         * keepAliceTime 当前线程数量超过 corePoolSize 时 则会进行使用
         * TimeUtil 超过时间的单位
         * WorkQueue 缓存将要执行的Runnble任务
         */
        ExecutorService bennfitPoolExecutor = new ThreadPoolExecutor(100,100,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

        bennfitPoolExecutor.execute(()->{
            while(true){
                System.out.println("呐, 我的大聪明要加油！！！！");
            }
        });


    }


}
