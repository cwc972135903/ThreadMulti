package CollectionsDemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/5/18 15:28
 */
public class ArrayListTest {
    public static void main(String ...args) throws InterruptedException {
        //Collections.synchronizedList();可以返回线程安全的ArrayList
        //添加元素逻辑：扩容-》赋值
        //线程安全问题测试:数组越界异常可能需要测试多次才会重现的； 数据会出现null的问题，这个是因为size++这个的操作不是原子性的，在字节码指令级别是分为好几个步骤的
        /*
        List<String> demoList = new ArrayList<>();
        Thread thread = new Thread(() -> {
            IntStream.range(0, 100).forEach(item -> {
                demoList.add(item + "");
                //System.out.println(Thread.currentThread().getName()+":"+item);
            });
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            IntStream.range(100, 200).forEach(item -> {
                demoList.add(item + "");
                //System.out.println(Thread.currentThread().getName()+":"+item);
            });
        });
        thread1.start();
        thread.join();
        thread1.join();

        demoList.forEach(item->{
            System.out.println(item);
        });

         */
        List<String> linkedList = new LinkedList<>();
        //Executors.newFixedThreadPool()
//        Node n = new Node();
//        n.name = "123";
//        Node n1 = new Node();
//        n1.name = "456";
//
//        Node n2 = n;
//        n = n1;
//
//        System.out.println(n2.name);
//        System.out.println(n1.name);
    }
}

class Node{
    String name;
}
