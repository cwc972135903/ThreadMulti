package ThreadDemo5.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/25 10:49
 */
public class PrintWithNotify {
    //变量定义在外面 如果想直接使用就需要定义static的，否则就写在main方法里也是可以的
    private static final Object o = new Object();
    private static final char[] cn = "1234567".toCharArray();
    private static final char[] sn = "ABCDEFG".toCharArray();
    public static void main(String[] args) {
        //这边需要用countDownLatch保证肯定是第一个线程运行
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            countDownLatch.countDown();
            synchronized (o){
                for (char n : cn) {
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }
        }, "Thread-N").start();

        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (o){
                for (char s : sn) {

                    System.out.println(Thread.currentThread().getName() + ":" + s);
                    //这里必须先notify在wait，因为wait是阻塞等待到 直到被别的线程唤醒才会继续执行的
                    //第一个线程打印了以后，先wait，第二个线程获取到锁了以后，打印，然后notify第一个线程，然后当前线程等待，第一个线程才可以执行，如果上来就wait
                    //那么两个线程都处于等待状态了
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }
        }, "Thread-S").start();
    }


}
