package DesignPattern.Singleton;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 14:37
 */
public class SingletonClassic1 {
    private static SingletonClassic1 INSTANCE_OBJ = null;

    private SingletonClassic1(){}

    public static SingletonClassic1 getInstance(){
        if(INSTANCE_OBJ == null){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE_OBJ = new SingletonClassic1();
        }

        return INSTANCE_OBJ;
    }
}
