package ThreadDemoNew;

import java.time.LocalDateTime;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/12 16:24
 */
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (;;){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("线程已经中断");
                    break;
                }
                System.out.println(LocalDateTime.now().toString());
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
