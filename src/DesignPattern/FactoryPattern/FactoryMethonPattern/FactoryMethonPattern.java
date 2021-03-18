package DesignPattern.FactoryPattern.FactoryMethonPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 15:26
 */
public class FactoryMethonPattern {
    public static void main(String ...args){
        InterfaceFactory factory = new FactoryA();
        Product product = factory.factoryMethod();
        product.individualMethod();
    }
}
