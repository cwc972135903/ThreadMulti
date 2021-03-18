package ThreadDemoNew;

import java.util.concurrent.*;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/15 13:55
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        FutureTask futureTask = new FutureTask(callableTest);
        //自己定义线程池
        ThreadPoolExecutor threadPool = ThreadPoolExecutorFactory.getThreadPool();
//        Future<?> submit = threadPool.submit(futureTask, "123");
////        System.out.println(submit.get());
        threadPool.execute(futureTask);
        System.out.println(futureTask.get());
        threadPool.shutdownNow();
    }
}
class CallableTest implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+":" + result);
            result += i;
        }
        return result;
    }
}
