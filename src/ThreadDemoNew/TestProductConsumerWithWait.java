package ThreadDemoNew;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/15 15:08
 */
public class TestProductConsumerWithWait {
    /**
     * 定义锁对象
     */
    public static Object lockObj = new Object();
    /**
     * 定义队列
     */
    public static Queue<String> queue = new LinkedList<>();

    public static int MAX_SIZE = 15;
    public static void main(String[] args) {
        //获取线程池
        ThreadPoolExecutor threadPool = ThreadPoolExecutorFactory.getThreadPool();
        //构建生产者线程
        threadPool.execute(new Producer());
        //构建消费者线程
        Consumer consumer = new Consumer();
        threadPool.execute(consumer);
        threadPool.execute(consumer);
        //停止线程，不用立即停止
        threadPool.shutdown();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    @Override
    public void run() {
        while (true){
            synchronized (TestProductConsumerWithWait.lockObj){
               while (TestProductConsumerWithWait.queue.size() == TestProductConsumerWithWait.MAX_SIZE){
                   System.out.println(Thread.currentThread().getName()+":当前队列已经满了，通知消费者消费");
                   try {
                       //释放锁
                       TestProductConsumerWithWait.lockObj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                //如果进入这，说明队列已经不满了，需要生产
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Produce " + i);
                TestProductConsumerWithWait.queue.add(i+"");
                //生产一个就通知别人拿
                TestProductConsumerWithWait.lockObj.notifyAll();
            }
        }

    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    @Override
    public void run() {
        while (true){
            synchronized (TestProductConsumerWithWait.lockObj){
                //如果空了就通知生产
                while (TestProductConsumerWithWait.queue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+":队列空了");
                    try {
                        TestProductConsumerWithWait.lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //消费一个就通知生产
                String v = TestProductConsumerWithWait.queue.remove();
                System.out.println(Thread.currentThread().getName()+":Consume " + v);
                TestProductConsumerWithWait.lockObj.notifyAll();
            }
        }

    }
}
