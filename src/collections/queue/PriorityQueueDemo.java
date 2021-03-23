package collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/23 9:37
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue<>();
//        //==========添加 数字，会自然排序
//        queue.add(1);
//        queue.add(3);
//        queue.add(2);
//        queue.add(10);
//        while (queue.size() > 0){
//            System.out.println(queue.poll());
//        }
//        //==========添加字符串
//        Queue<String> queue1 = new PriorityQueue<>(2);
//        queue1.add("a");
//        queue1.add("c");
//        queue1.add("b");
//        queue1.add("d");
//        System.out.println(queue1.size());
//        while (queue1.size() > 0){
//            System.out.println(queue1.poll());
//        }
       //===========添加对象
        Queue<Customer> queue3 = new PriorityQueue<>(2, (o1, o2) -> o1.getId() - o1.getId());
        Customer zs = new Customer("zs", 1);
        Customer ls = new Customer("ls", 3);
        Customer ww = new Customer("ww", 2);
        queue3.add(zs);
        queue3.add(ls);
        queue3.add(ww);
        while (queue3.size() > 0){
            System.out.println(queue3.poll().toString());
        }

    }
}
class Customer{
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}