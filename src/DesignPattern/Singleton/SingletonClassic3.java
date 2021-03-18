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
public class SingletonClassic3 {
    private static volatile SingletonClassic3 INSTANCE_OBJ = null;

    private SingletonClassic3(){}

    public  static SingletonClassic3 getInstance(){
        if(INSTANCE_OBJ == null){
            synchronized(SingletonClassic3.class){
                if(INSTANCE_OBJ == null){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE_OBJ = new SingletonClassic3();
                }

            }
        }

        return INSTANCE_OBJ;
    }
}
