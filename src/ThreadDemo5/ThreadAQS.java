package ThreadDemo5;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description:AQS: https://blog.csdn.net/mulinsen77/article/details/84583716
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 13:50
 */
public class ThreadAQS {
    public static void main(String ...args){
        //===========CountDownLatch====================
        /**
        final  int totalCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("begin......");
        IntStream.range(0,10).forEach(item->{
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+":"+ LocalDateTime.now());
                countDownLatch.countDown();
            });
        });
        try{
            System.out.println("wait......");
            countDownLatch.await();
            System.out.println("end......");
            executorService.shutdown();

        }catch (InterruptedException e){
            e.printStackTrace();
        }**/
        //===========CyclicBarrier====================
//        final int totalCount = 10;
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalCount);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        System.out.println("begin......");
//        IntStream.range(0,10).forEach(item->{
//            executorService.execute(()->{
//                System.out.println(Thread.currentThread().getName()+":"+ LocalDateTime.now());
//                try{
//
//                    cyclicBarrier.await();
//                }catch (BrokenBarrierException | InterruptedException e){
//                    e.printStackTrace();
//                }
//
//            });
//        });
//        executorService.shutdown();
//        System.out.println("end......");

        //===========CyclicBarrier====================
        //===========Semaphore====================
        final int clienCount = 2;
        final int totalCount = 10;

        Semaphore semaphore = new Semaphore(clienCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("begin......");
        IntStream.range(0,totalCount).forEach(item->{
            executorService.execute(()->{

                try{
                    semaphore.acquire();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+":"+item+"==="+ semaphore.availablePermits());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            });
        });
        executorService.shutdown();
        System.out.println("end......");
        //===========Semaphore====================
    }
}


