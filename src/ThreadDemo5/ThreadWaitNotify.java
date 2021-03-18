package ThreadDemo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: xCRMS </p>
 * Description: Wait Notify
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 10:23
 */
public class ThreadWaitNotify {
    public static void main(String ...args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();

        executorService.execute(()->{
            waitNotifyExample.after();
        });

        executorService.execute(()->{
            waitNotifyExample.before();
        });
    }
}

class WaitNotifyExample{
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after(){
        try{
            wait();
            System.out.println("after");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
