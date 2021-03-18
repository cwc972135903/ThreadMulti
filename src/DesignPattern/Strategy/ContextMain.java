package DesignPattern.Strategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 20:16
 */
public class ContextMain {
    private AbstractStrategy abstractStrategy;

    public ContextMain(AbstractStrategy abstractStrategy){
        this.abstractStrategy = abstractStrategy;
    }

    public void doDiscount(){
        abstractStrategy.doDiscount();
    }
}
