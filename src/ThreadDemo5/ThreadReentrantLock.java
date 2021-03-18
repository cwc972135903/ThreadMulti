package ThreadDemo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/30 22:26
 */
public class ThreadReentrantLock {
    public static void main(String ...args){
        ReentClass reentClass = new ReentClass();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            reentClass.func();
        });

        executorService.execute(()->{
            reentClass.func();
        });
    }
}

class ReentClass{
    private Lock lock1 = new ReentrantLock();

    public void func(){
        lock1.lock();
        try {
            IntStream.range(0, 10).forEach(item->{
                System.out.println(Thread.currentThread().getName()+":"+item);
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock1.unlock();

        }

    }
}
