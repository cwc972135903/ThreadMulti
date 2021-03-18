package DesignPattern.FactoryPattern.AbstractFactoryPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 16:12
 */
public class AbstractFactoryPattern {
    public static void main(String ...args){
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        productA.individualMethod();
        AbstractProductB productB = abstractFactory.createProductB();
        productB.individualMethod();
    }
}
