package DesignPattern.FactoryPattern.FactoryMethonPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: Factory <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 14:23
 */
public class FactoryA implements InterfaceFactory{

    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
