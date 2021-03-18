package ThreadDemo4;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: volatile只能保证线程的可见性，但是无法保证原子性<br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/25 11:41
 */
public class VolatileTest {


    public static void main(String ...args){
        runnable run = new runnable();
        List<Thread> threadList = new ArrayList<>();
        IntStream.range(0, 10).forEach(item -> {
            Thread thread = new Thread(run, "Thread" + item);
            threadList.add(thread);
        });
        threadList.forEach(item -> {
            item.start();
        });
        threadList.forEach(item -> {
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

      //  System.out.println(run.atomicInteger.get());
        System.out.println(run.count);
    }
}

class runnable implements Runnable{
    public volatile int count = 0;
   // AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        IntStream.range(0,10000).forEach(item->{
            //atomicInteger.incrementAndGet();
            //count++不是原子的，volatile只能保证可见性
            count++;
            System.out.println(Thread.currentThread().getName() + "==" + count);

        });
    }
}

