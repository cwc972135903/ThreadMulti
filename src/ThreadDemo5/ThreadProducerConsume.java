package ThreadDemo5;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 19:22
 */
public class ThreadProducerConsume {
    public static void main(String ...args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ProducerConsume producerConsume = new ProducerConsume();
        IntStream.range(0,3).forEach(item -> {
            executorService.execute(() -> {
                producerConsume.putProduct();
            });
        });
        IntStream.range(0,5).forEach(item -> {
            executorService.execute(() -> {
                producerConsume.getProduct();
            });
        });
        IntStream.range(0,2).forEach(item -> {
            executorService.execute(() -> {
                producerConsume.putProduct();
            });
        });

        executorService.shutdown();
    }
}

class ProducerConsume{
    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);
    public void putProduct(){
        try {
            blockingQueue.put("prodcut");
            System.out.println("put Product");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getProduct(){
        try {
            blockingQueue.take();
            System.out.println("take Product");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

