package ThreadDemo5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: xCRMS </p>
 * Description: 线程执行框架Executor
 * 1. 有需要就会创建一个线程
 * 2. 可以重复使用之前创建的线程，如果当前没有可重复使用的就创建新的线程添加到池子当中
 * 3. 如果线程60s还没被使用过，那么就会从缓存池中移除线程
 * 4. 根据阿里的规范手册，应该使用ThreadPoolExecutor的构造方法进行创建线程池，而不是那几个封装过的，那个没有限制线程数量，容易OOM
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/30 19:04
 */
public class ThreadExecutor {
    public static void main(String ...args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {

            executorService.execute(new MyRunnable());
        }
        System.out.println("线程都启动了");
        //不主动调用这个线程不会关闭，调用了以后等当前线程执行完就关闭了
        //调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
        executorService.shutdown();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(2_000);
            System.out.println("线程正在执行：" + LocalDateTime.now());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
