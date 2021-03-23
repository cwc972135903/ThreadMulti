package collections.queue;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/22 16:53
 */
public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        Deque<String> queue = new ConcurrentLinkedDeque<>();
        queue.addFirst("123");
        queue.pollFirst();
        System.out.println(queue.size());
    }
}
