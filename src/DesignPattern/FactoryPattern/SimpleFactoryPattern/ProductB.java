package DesignPattern.FactoryPattern.SimpleFactoryPattern;

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
public class ProductB extends Product {
    @Override
    public void individualMethod() {
        System.out.println("ProductB: individualMethod");
    }
}
