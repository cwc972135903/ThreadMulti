package ThreadDemoNew;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 7个参数：
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/15 14:00
 */
public class ThreadPoolExecutorFactory {
    /**
     * 定义核心线程数量
     */
    private static final int CORP_POOL_SIZE = 5;
    /**
     *定义最大线程数量
     */
    private static final int MAXIMUM_POOL_SIZE = 50;
    /**
     *定义空闲线程存活时间单位
     */
    private static final long KEEP_ALIVE_TIME = 1L;
    /**
     * 定义工作队列
     */
    private static BlockingQueue blockingQueue = new ArrayBlockingQueue<>(100);

    public static ThreadPoolExecutor getThreadPool(){
       return  new ThreadPoolExecutor(
               CORP_POOL_SIZE,
               MAXIMUM_POOL_SIZE,
               KEEP_ALIVE_TIME,
               TimeUnit.SECONDS,
               blockingQueue,
               new ThreadPoolExecutor.CallerRunsPolicy()
       );
    }
}
