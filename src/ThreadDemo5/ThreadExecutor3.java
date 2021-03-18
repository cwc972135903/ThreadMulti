package ThreadDemo5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: 通过ThreadPoolExecutor创建线程池, callable的方式<br>
 * 1.新线程到来，当前运行的线程是否大于核心线程数量，如果没有，直接加入核心线程运行
 * 2.如果核心线程满了，判断等待队列是否满了，如果等待队列没有满，加入等待队列，等待执行
 * 3，如果等待队列也满了，查看线程池空闲线程是否还有，如果有创建线程执行
 * 4. 如果线程池也没了，直接使用拒绝策略，根据初始化ThreadPoolExecutor的策略进行操作
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/23 16:04
 */
public class ThreadExecutor3 {
    //定义核心线程数量
    private static final int CORP_POOL_SIZE = 5;
    //定义最大线程数量
    private static final int MAXIMUM_POOL_SIZE = 50;
    //定义空闲线程存活时间单位
    private static final long KEEP_ALIVE_TIME = 1L;
    //定义空闲线程存活时间
    //定义工作队列
    private static BlockingQueue blockingQueue = new ArrayBlockingQueue<>(100);
    public static void main(String ...args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORP_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, blockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future> futureList = new ArrayList<>();
        IntStream.range(0, 9).forEach(item -> {
            Future submit = threadPoolExecutor.submit(new CallableTest());
            futureList.add(submit);

        });
        futureList.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        });
        threadPoolExecutor.shutdown();


    }
}

class CallableTest implements Callable{

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName()+"Start:" + "--" + LocalDateTime.now().toString());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"end:"+ "--" + LocalDateTime.now().toString());

        return Thread.currentThread().getName()+"|执行成功";
    }
}

