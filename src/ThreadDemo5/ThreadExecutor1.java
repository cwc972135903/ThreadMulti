package ThreadDemo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>Title: xCRMS </p>
 * Description:
 * 1. 同步代码块和同步方法作用于同一个对象，两个新的实例之间是互相不影响的
 * 2. 锁的粒度越小性能越好
 * 3.
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/30 21:15
 */
public class ThreadExecutor1 {
    public static void main(String ...args){
        TestClass testClass = new TestClass();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            testClass.func();
        });
        executorService.execute(()->{
            testClass.func();
        });
        executorService.shutdown();
    }
}

class TestClass{
    public synchronized void func(){
        IntStream.range(0, 10).forEach(item->{
            System.out.println(Thread.currentThread().getName()+":"+item);
        });

    }
}
