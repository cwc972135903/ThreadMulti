package ThreadDemo1;

/**
 * <p>Title: xCRMS </p>
 * Description:
 * 1. 直接调用run方法是没用的，那不是启动一个线程，调用start才会有‘线程规划器’ 调度
 * 2. 多线程是异步的，代码里线程的执行顺序并不是代码真正的运行顺序（线程是一个子任务，cpu以不确定的方式来调用线程的run方法）
 * 3. 一个进程在运行至少会有一个非守护线程在运行，如果当前一个线程都没了，守护线程自然也就挂了
 * 4. new -> 就绪 -> runabble -> running- > block -> terminate -> stop
 * 5.start 方法多次调用会报错的
 * 6.线程数量太多也是占用cpu的，不是越多越好，需要的场景使用即可
 * 7. 多线程共享变量问题，需要考虑线程安全性
 * 8. 当创建匿名内部类时，必须实现接口或抽象父类里的所有抽象方法。如果有需要，也可以重写父类中的普通方法。
 * 9. 当前线程请求的深度超出虚拟机栈的栈深度，会抛出stackoverflow异常，可以自己设置这个深度大小
 * 10. 线程组可以统一管理线程
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2019/12/14 22:48
 */
public class ThreadTest {
    public static void main(String args[]) throws InterruptedException {


//       ThreadDemo threadDemo = new ThreadDemo();
//
//       threadDemo.start();
//       //主线程停止2秒，让子线程继续运行 输出点东西
//       Thread.sleep(2000);
//       threadDemo.interrupt();

//        System.out.println("begin =" + System.currentTimeMillis());
//        threadDemo.start();
//        System.out.println("end =" + System.currentTimeMillis());
         int i = 0;
         int j = i++;
         System.out.println(i);
         System.out.println(j);

    }

}
