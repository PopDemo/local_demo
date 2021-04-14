package cn.loca.ideaproject;


/**
 *
 */
public class ThreaInterrupTest implements Runnable{

        public void run(){
            try {
                while (true) {
                    // interrupred
                    // 获取到当前线程的阻塞装填
                    Boolean a = Thread.currentThread().isInterrupted();
                    System.out.println("in run() - about to sleep for 20 seconds-------" + a);
                    //    当阻塞方法收到中断请求的时候就会抛出InterruptedException异常
                    Thread.sleep(20000);
                    System.out.println("in run() - woke up");
                }
            } catch (InterruptedException e) {
                //查看当前线程的 阻塞状态 并将 状态调为 false
                Thread.currentThread().interrupt();//如果不加上这一句，那么cd将会都是false，因为在捕捉到InterruptedException异常的时候就会自动的中断标志置为了false


                /**
                 * 为什么c的阻塞状态为true
                 */
                Boolean c=Thread.interrupted();


                Boolean d=Thread.interrupted();
                System.out.println("c="+c);
                System.out.println("d="+d);
            }
        }




        public static void main(String[] args) {
            ThreaInterrupTest si = new ThreaInterrupTest();
            Thread t = new Thread(si);
            t.start();
            //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("in main() - interrupting other thread");
            //中断线程t
            t.interrupt();
            System.out.println("in main() - leaving");
        }

}
