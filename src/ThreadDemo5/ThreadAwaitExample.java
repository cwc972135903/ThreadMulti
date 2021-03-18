package ThreadDemo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 11:29
 */
public class ThreadAwaitExample {
    public static void main(String ...args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        AwaitExample awaitExample = new AwaitExample();

        executorService.execute(()->{
            awaitExample.after();
        });

        executorService.execute(()->{
            awaitExample.before();
        });
    }
}

class AwaitExample{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public  void before(){
        lock.lock();
        try{
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public  void after(){
        lock.lock();
        try{
            condition.await();
            System.out.println("after");

        }catch (InterruptedException e){
            lock.unlock();
            e.printStackTrace();
        }

    }
}

