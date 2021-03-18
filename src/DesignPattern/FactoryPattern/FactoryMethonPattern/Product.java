package DesignPattern.FactoryPattern.FactoryMethonPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: Abstract Class
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/21 14:21
 */
public abstract class Product {
    /**
     * 公共方法
     */
    public void commonMethod(){
        System.out.println("Invoke CommmonMethod!");
    }

    /**
     * 个性化方法
     */
    public abstract void individualMethod();
}
