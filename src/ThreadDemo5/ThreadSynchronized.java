package ThreadDemo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: 锁住同一个类
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/30 21:44
 */
public class ThreadSynchronized {
    public static void main(String ...args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        TestSync testSync = new TestSync();

        executorService.execute(() -> {
            testSync.func();
        });

        TestSync testSync1 = new TestSync();

        executorService.execute(() -> {
            testSync1.func();
        });

        executorService.shutdown();
    }
}

class TestSync{
    public void func(){
        synchronized (TestSync.class){
            IntStream.range(0, 10).forEach(item -> {
                System.out.println(Thread.currentThread().getName()+":" + item);
            });
        }

    }
}
