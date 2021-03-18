package DesignPattern.Strategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 20:15
 */
public class ConcreteStrategyA extends AbstractStrategy {
    @Override
    public void doDiscount() {
        System.out.println("打七折...");
    }
}
