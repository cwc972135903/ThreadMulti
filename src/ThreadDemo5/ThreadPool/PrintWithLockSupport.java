package ThreadDemo5.ThreadPool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/25 10:49
 */
public class PrintWithLockSupport {
    //变量定义在外面 如果想直接使用就需要定义static的，否则就写在main方法里也是可以的
    private static final char[] cn = "1234567".toCharArray();
    private static final char[] sn = "ABCDEFG".toCharArray();
    private static  Thread thread = null;
    private static  Thread thread1 = null;
    public static void main(String[] args) {
        //在调用对象的Wait之前当前线程必须先获得该对象的监视器(Synchronized)，被唤醒之后需要重新获取到监视器才能继续执行。
        //而LockSupport并不需要获取对象的监视器。LockSupport机制是每次unpark给线程1个"许可"——最多只能是1，而park则相反，如果当前线程有许可，那么park方法会消耗1个并返回，否则会阻塞线程直到线程重新获得许可，在线程启动之前调用 park/unpark方法没有任何效果。
        thread = new Thread(() -> {
            for (char n : cn) {
                System.out.println(Thread.currentThread().getName() + ":" + n);
                //给线程1一个许可
                LockSupport.unpark(thread1);
                //当前线程阻塞，等待一个许可
                LockSupport.park();
            }
        }, "Thread-N");
        thread.start();
        thread1 = new Thread(()->{
            for (char s : sn) {
                //如果当前线程有许可，消耗一个许可并返回，不会阻塞
                //上来先park是因为怕线程thread还没执行完输出，thread1就执行了，所以先阻塞等待线程thread唤醒
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + ":" + s);
                LockSupport.unpark(thread);
            }
        }, "Thread-S");
        thread1.start();
    }
}
