package DesignPattern.FactoryPattern.FactoryMethonPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: 工厂接口<br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 15:26
 */
public interface InterfaceFactory {
    /**
     * 由具体的工厂字类实现
     * @return
     */
    Product factoryMethod();

    //todo: 这边可以使用重载的模式，比如可以传入一些参数的，而不是固定参数的
}
