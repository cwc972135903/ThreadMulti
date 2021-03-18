package DesignPattern.Singleton;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 16:58
 */
public class SingletonClassic {
    private static SingletonClassic INSTANCE_OBJ = new SingletonClassic();
    private SingletonClassic(){}

    public static SingletonClassic getInstance(){
        return INSTANCE_OBJ;
    }
}
