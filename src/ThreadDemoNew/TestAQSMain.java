package ThreadDemoNew;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/19 13:33
 */
public class TestAQSMain {
    private int value;

    private TestCustomAQS myAQSLock = new TestCustomAQS();

    public int next(){
        myAQSLock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            myAQSLock.unlock();
        }
    }
    public void a() {
        myAQSLock.lock();
        System.out.println("a");
        b();
        myAQSLock.unlock();
    }

    public void b() {
        myAQSLock.lock();
        System.out.println("b");
        myAQSLock.unlock();
    }
    public static void main(String[] args) {
        TestAQSMain test = new TestAQSMain();


        new Thread(() -> test.a()).start();
        new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName()+"  "+test.next());
            }
        }).start();
        new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName()+"  "+test.next());
            }
        }).start();
        new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName()+"  "+test.next());
            }
        }).start();
    }
}
