package ThreadDemoNew;

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
 * @date 2021/3/12 16:44
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            IntStream.range(0, 10).forEach(item->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+item);
            });
        },"cwc1");
        Thread thread2 = new Thread(() -> {
            IntStream.range(0, 10).forEach(item->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+item);
            });

        }, "cwc2");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("两个线程都执行完毕了");
    }
}
