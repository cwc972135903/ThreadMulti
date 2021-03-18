package ThreadDemo4;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * 0. Synchronized锁住的是对象
 * 1. 同步代码块：锁住的是某个对象，要访问这个代码块需要获得当前对象头里面的锁
 * 2. 同步方法  锁定的是当前this对象
 * 3. 静态代码块加的锁是当前 .class对象的锁
 * 缺点： 可能出现死锁
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/22 18:17
 */
public class SynchronizedTest {
    public static void main(String ...args){
        ThisLock thisLock = new ThisLock();

        new Thread(()->{

            try{
                thisLock.m1();

            }catch (Exception e){
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(()->{
            try{

                try{
                    thisLock.m2();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "T2").start();
    }
}

class ThisLock{
    public synchronized void m1(){
        try{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void m2(){
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}