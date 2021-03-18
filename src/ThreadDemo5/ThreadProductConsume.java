package ThreadDemo5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Title: xCRMS </p>
 * Description: Wait Notify
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/31 10:23
 */
public class ThreadProductConsume {
    public static void main(String ...args){
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;
        Producer p = new Producer(queue, maxSize);
        Consumer c = new Consumer(queue, maxSize);
        Thread pT = new Thread(p);
        Thread pC = new Thread(c);
        pT.start();
        pC.start();
    }
}
class Producer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try{
                        System.out.println("Queue is Full");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Produce " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}
class Consumer implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
            }

    @Override
    public void run() {
            while (true){
                synchronized (queue){
                        while (queue.isEmpty()){
                            System.out.println("Queue is Empty");
                            try{
                                queue.wait();
                            }catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                        }
                        int v = queue.remove();
                        System.out.println("Consume " + v);
                        queue.notifyAll();
                }
            }
    }
}
