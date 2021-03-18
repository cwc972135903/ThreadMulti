package ThreadDemo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
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
 * @date 2020/6/9 21:55
 */
public class WithoutHoldingLock {
    List<Object> list  = new ArrayList<>();
    public static void main(String[] args) {
        WithoutHoldingLock whl = new WithoutHoldingLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("T1 start");
            if(whl.list.size() != 5){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T1 end");
            countDownLatch1.countDown();
        }, "T1").start();

        new Thread(()->{
            System.out.println("T2 start");
            IntStream.range(0, 10).forEach(item -> {
                whl.list.add(new Object());
                System.out.println("add:"+item);
                try {
                    //如果把休眠时间去掉，那么T1的end打印不一定刚好在add4 之后了，因为T2也在继续执行，可以用两个countDown(LockSuuport的用法也是类似)
//                    TimeUnit.SECONDS.sleep(1);
                    if(whl.list.size() == 5){
                        countDownLatch.countDown();
                        countDownLatch1.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("T2 end");
        }, "T2").start();
    }
}
