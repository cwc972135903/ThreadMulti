package ThreadDemo2;

import java.util.Optional;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 1. 优先级并不一定是按这个来的，设置了可能无效
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/5 15:42
 */
public class TreaadOtherApi {
    public static void main(String... args){
        Thread t = new Thread(()->{
            Optional.of("hello").ifPresent(System.out::println);
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        t.start();

        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
