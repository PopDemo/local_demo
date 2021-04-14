package cn.speed_limiter.test;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class localTest {




    private final static int MAX_QOS=50;
    //发券方法一秒内信号量 本身就持有thread的属性
    private final static Semaphore couponSemaphore = new Semaphore(MAX_QOS);
    //发券方法一秒内计数器
    private final static AtomicLong couponSendCountPer = new AtomicLong(0);
    //发券方法执行器,线程池
    private final static ExecutorService couponSendThreadPool = new ThreadPoolExecutor(100, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
    //发券方法一秒内计数器定时任务
    private final static ScheduledExecutorService  couponQosSchedule = Executors.newScheduledThreadPool(1);
    //初始化发券方法计数器定时任务并启动
    static{
        couponQosSchedule.scheduleAtFixedRate(() -> {
            long tempCount = couponSendCountPer.get();
            if(tempCount>0){
                System.out.println("调用驿氪发券接口一秒内计数:------>"+tempCount);
            }
            //计数器归零
            couponSendCountPer.set(0);
            //重置信号量
            couponSemaphore.release(MAX_QOS);
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }


    @Test
    public void init(){

        for (int i = 0; i < 1000000; i++) {
            pushOrder();
        }
    }

    public String pushOrder(){
        try {
            couponSendThreadPool.execute(()->{
                //占用一个信号位
                couponSemaphore.acquireUninterruptibly(1);
                pushOrder();
                System.out.println("当前执行数为："+couponSendCountPer.get());
            });
        } catch (Exception e) {
            System.out.println("执行error:{}"+e);
        }
//        System.out.println("当前方法的信号量为："+thisSum);
        return "执行推送方法数量"+couponSendCountPer.doubleValue();
    }





}
