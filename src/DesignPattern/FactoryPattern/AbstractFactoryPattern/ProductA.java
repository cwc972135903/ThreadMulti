package DesignPattern.FactoryPattern.AbstractFactoryPattern;

import DesignPattern.FactoryPattern.FactoryMethonPattern.Product;

/**
 * <p>Title: xCRMS </p>
 * Description: 具体的字类<br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 14:26
 */
public class ProductA extends AbstractProductA {
    @Override
    public void individualMethod() {
        System.out.println("ProductA: individualMethod ");
    }
}
