package ThreadDemo5.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/25 10:27
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("自定义线程池");
        MyRejectHandle myRejectHandle = new MyRejectHandle();
//        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
//            2, 5, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4),myThreadFactory, new ThreadPoolExecutor.DiscardPolicy()
//        );
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
            2, 5, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4),myThreadFactory, myRejectHandle
        );

        //当max+队列总共=9， 但是我们启动了10个任务，因此根据拒绝策略，第10个被抛弃了
        //刚开始上来两个task把核心线程沾满了0 和 1
        //后面来的四个任务，2 3 4 5 把队列沾满了
        //这时候如果核心线程还没执行完，就使用剩余的三个空闲线程 执行 6 7 8
        //这时候如果0 1 6 7 8  执行完了，队列里面的会进去占满核心线程 2 3 4 5 执行
        IntStream.range(0, 10).forEach(item->{
            threadPoolExecutor.execute(()->{

                System.out.println(Thread.currentThread().getName()+"======"+item);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        });

        threadPoolExecutor.shutdown();
    }
}

class MyThreadFactory implements ThreadFactory{
    private final String namePrefix;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public MyThreadFactory(String groupName){
        namePrefix = groupName+",线程编号:";
    }

    @Override
    public Thread newThread(Runnable r) {
        String threadName = namePrefix + atomicInteger.getAndIncrement();
        Thread thread = new Thread(null, r, threadName, 0);
        return thread;
    }
}

class MyRejectHandle implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //1.记录异常
        //2.报警处理等
        //3.塞到kafaka里面
        //4.失败重试机制
        //..根据业务场景指定操作
        if(executor.getQueue().size() < 4){
            //重新放回到队列
            executor.execute(r);
        }
        System.out.println("error.............");
    }
}
