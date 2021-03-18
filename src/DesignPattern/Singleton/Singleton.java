package DesignPattern.Singleton;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 16:54
 */
public class Singleton {
    public static void main(String ...args){
//       System.out.println(SingletonClassic.getInstance().hashCode());
//       System.out.println(SingletonClassic.getInstance().hashCode());
//        new Thread(()->{
//            System.out.println(SingletonClassic2.getInstance().hashCode());
//        }).start();
//        new Thread(()->{
//            System.out.println(SingletonClassic2.getInstance().hashCode());
//        }).start();

        new Thread(()->{
            System.out.println(SingletonClassic3.getInstance().hashCode());
        }).start();
        new Thread(()->{
            System.out.println(SingletonClassic3.getInstance().hashCode());
        }).start();
    }
}
