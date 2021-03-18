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
 * @date 2020/4/21 16:15
 */
public abstract class AbstractProduct {
    public void commonMethod(){
        System.out.println("AbstractProduct:commonMethod");
    }
    public abstract void individualMethod();
}
