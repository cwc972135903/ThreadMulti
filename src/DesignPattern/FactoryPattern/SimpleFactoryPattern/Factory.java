package DesignPattern.FactoryPattern.SimpleFactoryPattern;

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
public class Factory {
    /**
     * 返回对应的产品子类
     */
    public static Product getProduct(String type){
        Product product = null;
        if(type.equalsIgnoreCase("A")){
            product = new ProductA();
        }else if(type.equalsIgnoreCase("B")){
            product = new ProductB();
        }

        return product;
    }
}
