package ThreadDemo2;

import java.util.Collections;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 1.join的作用是当前线程等到别的线程执行完以后才能执行, 比如main线程调用A.join()是 main线程等待A执行完以后才可以执行，当前线程被挂起
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/5 15:56
 */
public class ThreadJoinTest {
    public static void main(String... args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            IntStream.range(0, 1000).forEach(item ->{
                System.out.println(Thread.currentThread().getName()+"-"+item);
            });
        });

        t1.start();
        t1.join();
        IntStream.range(0, 1000).forEach(item ->{
            System.out.println(Thread.currentThread().getName()+"-"+item);
        });
    }
}
