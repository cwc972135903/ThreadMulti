package ThreadDemo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>Title: xCRMS </p>
 * Description: 实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，
 * 不是真正意义上的线程，因此最后还需要通过 Thread 来调用。可以理解为任务是通过线程驱动从而执行的。
 * Callable 可以有返回值，返回值通过 FutureTask 进行封装
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/30 18:27
 */
public class ThreadCallable {
    public static void main(String ...args) throws ExecutionException, InterruptedException {
        TestCallable testCallable = new TestCallable();

        //FutureTask 最终实现了Runnable
        FutureTask futureTask = new FutureTask(testCallable);

        Thread thread = new Thread(futureTask);

        thread.start();
        System.out.println("start");
        //会等线程执行完毕以后才会执行
        System.out.println(futureTask.get());

    }
}

/**
 * 泛型类的继承原则，子类可以选择实现，也可以比父类的泛型类型多，也可以不实现直接指定一个类型
 */
class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(4_000);
        return 123;
    }
}
