package ThreadDemoNew;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/15 10:01
 */
public class TestWaitNotify {
    public static Object lockObj = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lockObj){
                try {
                    lockObj.wait();
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(Thread.currentThread().getName()+":" + i);
                    }
                    System.out.println(Thread.currentThread().getName()+":执行完毕");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T1").start();

        new Thread(()->{
            synchronized (lockObj){
                try {
                    lockObj.wait();
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(Thread.currentThread().getName()+":" + i);
                    }
                    System.out.println(Thread.currentThread().getName()+":执行完毕");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2").start();

        new Thread(()->{
            synchronized (lockObj){
                System.out.println(Thread.currentThread().getName()+":执行完毕,调用notify方法");
                lockObj.notify();
            }
        }, "T3").start();
    }

}
