package DesignPattern.FactoryPattern.AbstractFactoryPattern;

import DesignPattern.FactoryPattern.FactoryMethonPattern.Product;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 14:27
 */
public class ProductB extends AbstractProductB {
    @Override
    public void individualMethod() {
        System.out.println("ProductB: individualMethod");
    }
}
