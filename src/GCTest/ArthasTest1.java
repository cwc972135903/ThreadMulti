package GCTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/6 9:07
 */
public class ArthasTest1 {
    private static class CardInfo{
        BigDecimal bigDecimal = new BigDecimal(0.00);
        String name = "张三";
        int age = 5;
        Date birthDay = new Date();
        public void m(){
            System.out.println("do m...");
        }
    }
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String ...args) throws Exception{
        executor.setMaximumPoolSize(50);
        for (;;){
            modelFit();
            Thread.sleep(1000);
        }
    }

    private static void modelFit(){
        List<CardInfo> taskList = getAllCardInfo();
        taskList.forEach(item -> {
            executor.scheduleWithFixedDelay(()->{
                item.m();
            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    private static List<CardInfo> getAllCardInfo(){
        List<CardInfo> taskList = new ArrayList<>();
        IntStream.range(0, 100).forEach(item -> {
            taskList.add(new CardInfo());
        });

        return taskList;

    }

}
