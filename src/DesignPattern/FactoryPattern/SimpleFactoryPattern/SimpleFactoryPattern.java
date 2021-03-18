package DesignPattern.FactoryPattern.SimpleFactoryPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: Simple Factory Pattern
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 14:17
 */
public class SimpleFactoryPattern {
    public static void main(String ...args){
        Product aProduct = Factory.getProduct("A");
        aProduct.individualMethod();
        Product bProduct = Factory.getProduct("B");
        bProduct.individualMethod();
    }
}
