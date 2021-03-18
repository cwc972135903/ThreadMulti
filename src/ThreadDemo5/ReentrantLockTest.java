package ThreadDemo5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/25 16:48
 */
public class ReentrantLockTest {
    ReentrantLock reentrantLock = new ReentrantLock();
    void m1(){
        reentrantLock.lock();
        try{
            for(int i=0; i<10; ++i){
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
    void m2(){
        boolean locked = false;
        try {
            locked = reentrantLock.tryLock(11, TimeUnit.SECONDS);
            System.out.println("m2 lock "+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(locked){
                reentrantLock.unlock();

            }
        }
    }
    public static void main(String ...args){
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(reentrantLockTest::m2).start();

    }
}
