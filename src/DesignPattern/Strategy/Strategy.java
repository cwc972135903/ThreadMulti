package DesignPattern.Strategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 20:14
 */
public class Strategy {
    public static void main(String ...args){
        //ContextMain contextMain = new ContextMain(new ConcreteStrategyA());
        ContextMain contextMain = new ContextMain(new ConcreteStrategyB());
        contextMain.doDiscount();
    }
}
