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
public class SingletonClassic2 {
    private static SingletonClassic2 INSTANCE_OBJ = null;

    private SingletonClassic2(){}

    public synchronized static SingletonClassic2 getInstance(){
        if(INSTANCE_OBJ == null){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE_OBJ = new SingletonClassic2();
        }

        return INSTANCE_OBJ;
    }
}
