package ThreadDemo5;

import java.util.LinkedList;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，能够支持两个生产者线程以及10个消费者线程的调用
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/14 17:42
 */
public class SynchronizedContainer<T> {
    //添加元素的链表，保证顺序性， 插入快
    private   LinkedList<T> list = new LinkedList<>();
    //数量
    private int count = 0;
    //总数
    private final int MAX = 50;
    public static void main(String[] args) {
        SynchronizedContainer<String> synchronizedContainer = new SynchronizedContainer();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + ":" + synchronizedContainer.get());
                }
            }, "C").start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    synchronizedContainer.set(Thread.currentThread().getName()+"-"+j);
                    System.out.println(Thread.currentThread().getName() + "-"+j);
                }
            }, "P").start();
        }
    }

    /**
     * 当list长度不为0，可以拿数据，当list长度为0了，需要wait,唤醒生产者添加东西
     *
     */
    public synchronized T  get(){

        T t = null;
        //如果用if的话，当wait过后，重新获取执行权限的时候，就不会判断list.size == 0这个条件了，这时候会如果size还是0，那么后面的就报错了
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        //缺陷，同样会叫醒消费者线程，来争取这把锁， 需要做到只叫 生产者， 同样生产者只能叫醒消费者线程
        //需要使用ReentrantLock的condition
        //condition的本质就是增加等待队列，原来synchronized只有一个等待队列
        //而lock.newCondition()，new一个就多一个等待队列
        this.notifyAll();
        return t;

    }

    /**
     * 当list的长度小于50，不断添加东西，当满了以后，wait当前线程，然后notifyAll消费者线程进行消费
     */
    public synchronized void set(T t){
        //不用if的原因和上面一样的
        while (list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        //通知其他线程进行消费
        this.notifyAll();
    }

    public int getCount(){
        return count;
    }
}
