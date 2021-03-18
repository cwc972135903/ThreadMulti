package ThreadDemo5;

import java.util.concurrent.*;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 18:49
 */
public class ThreadFutureTask {
    public static void main(String ...args){
        FutureTest futureTest = new FutureTest();
        //因为callable是不能给new Thread作为参数传递的，因此需要使用FutureTask对callable进行封装
        FutureTask<Integer> futureTask = new FutureTask<>(futureTest);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);
        try{
            System.out.println(futureTask.get());
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

class FutureTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            result += i;
        }
        return result;
    }
}
