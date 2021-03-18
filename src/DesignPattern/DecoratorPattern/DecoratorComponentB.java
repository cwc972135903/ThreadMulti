package DesignPattern.DecoratorPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 16:34
 */
public class DecoratorComponentB extends DecoratorComponent {
    private AbstractComponent abstractComponent;
    public DecoratorComponentB(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    public void display(){
        this.extentB();
        super.display();
    }
    public void extentB(){
        System.out.println("extent Com B function");
    }
}
