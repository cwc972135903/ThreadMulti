package ThreadDemo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/9 21:17
 */
public class WaitNotifyHoldingLock {
    final  Object lockObj = new Object();
     List<Object> list = new ArrayList<>();
    public static void main(String[] args) {
        WaitNotifyHoldingLock waitNotifyHoldingLock = new WaitNotifyHoldingLock();
        //先wait监听，如果监听不到 就notify另一个线程执行
        new Thread(()->{
            System.out.println("t1 start");
            synchronized (waitNotifyHoldingLock.lockObj){
                if(waitNotifyHoldingLock.list.size() != 5){
                    try {
                        waitNotifyHoldingLock.lockObj.wait();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 end");
                waitNotifyHoldingLock.lockObj.notify();
            }
        }, "T1").start();
        // 如果获取到锁了，往数组里面添加数据， 如果size == 5， 当前线程wait，然后notify另一个线程
        new Thread(()->{
            System.out.println("t2 start");
            synchronized (waitNotifyHoldingLock.lockObj){
                IntStream.range(0, 10).forEach(item -> {
                    waitNotifyHoldingLock.list.add(new Object());
                    System.out.println("add:"+item);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        if(waitNotifyHoldingLock.list.size() == 5){
                            try {
                                //notify不释放锁
                                waitNotifyHoldingLock.lockObj.notify();
                                waitNotifyHoldingLock.lockObj.wait();

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
                System.out.println("t2 end");
            }
        },"T2").start();
    }


}
