package ThreadDemo5.ThreadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/28 23:00
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask myTask = new MyTask(0, 100000, 50000);
        forkJoinPool.execute(myTask);
        System.out.println(myTask.join());
    }


}

class MyTask extends RecursiveTask<Long> {
    private int start;
    private int end;
    private int max;
    public MyTask(int start, int end, int max){
        this.start = start;
        this.end = end;
        this.max = max;
    }

    @Override
    protected Long compute() {
        if(end-start<max){
            Long sum = 0L;
            for (int i = 0; i < end; i++) {
                sum += i;
            }
            return sum;
        }else{
            int middle = start + (end-start)/2;
            MyTask myTask = new MyTask(start, middle, max);
            MyTask myTask1 = new MyTask(middle, end, max);
            //看是否需要继续分离
            myTask.fork();
            myTask1.fork();
            //获取计算结果
            return myTask.join()+myTask1.join();
        }
    }
}
