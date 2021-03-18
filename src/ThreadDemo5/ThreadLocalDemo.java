package ThreadDemo5;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/23 17:23
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {

        final ThreadLocal threadLocal = new ThreadLocal();

        threadLocal.set("hello");
//        threadLocal.set("hello123"); //如果想有不同的threadLocal值就需要new多个对象，不然一个对象多次set，就是一个值

        System.out.println("main thread:" + threadLocal.get());

        new Thread(() -> {

            threadLocal.set("world");

            System.out.println("new Thread1:" + threadLocal.get());

        }).start();

        new Thread(() -> {

            threadLocal.set("!!!");

            System.out.println("new Thread2:" + threadLocal.get());

        }).start();
    }
}
