package ThreadDemo5.ThreadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/25 17:24
 */
public class PrintNotifyWithCondition {
    //变量定义在外面 如果想直接使用就需要定义static的，否则就写在main方法里也是可以的
    private static final char[] cn = "1234567".toCharArray();
    private static final char[] sn = "ABCDEFG".toCharArray();
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(()->{
            lock.lock();

            try {
                for (char n : cn) {
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    condition2.signal();
                    condition1.await();
                }
                //防止for结束以后继续阻塞
                condition2.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }, "Thread-N").start();

        new Thread(()->{
            lock.lock();
            try {
                for (char n : sn) {
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    condition1.signal();
                    condition2.await();
                }
                //防止for结束以后继续阻塞
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "Thread-S").start();

    }
}
