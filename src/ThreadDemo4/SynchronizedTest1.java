package ThreadDemo4;

import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 21:25
 */
public class SynchronizedTest1 {
    public static void main(String ...args){
        Runnable runnable = new ThreadDemo();
        IntStream.range(0,10).forEach(item -> {
            new Thread(runnable, "T1").start();
        });

    }
}

/**
 * 加了synchronized以后，会把count变成同步加线程之间可见的，不需要volatile
 */
class ThreadDemo implements Runnable{
    private int count = 10;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+":"+count);
    }
}
