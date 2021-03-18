package ThreadDemo2;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 1.守护线程
 * 2. main线程结束以后，其创建的守护线程也会结束，也就是说，当前不存在任何一个非守护线程时，守护线程就结束了
 * 3. 用于心跳检测，当应用线程都挂了，daemon的线程就可以挂了，如果不是守护线程，这个线程就会一直在
 * 4. A线程创建B线程，如果B线程是守护线程，A挂了B就挂了，否B还会一直在，应用不会退出，资源不会释放
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/5 15:10
 */
public class ThreadDaemonTest {
    public static void main(String... args) throws InterruptedException {

        Thread test = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+"start");
                Thread.sleep(10_000);
                System.out.println(Thread.currentThread().getName()+"end");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        //守护线程必须在start之前启动
       // test.setDaemon(true);
        test.start();
        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName()+":main-end");
    }
}
