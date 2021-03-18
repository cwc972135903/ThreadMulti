package DesignPattern.DecoratorPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 16:27
 */
public class DecoratorComponent extends AbstractComponent {
    private AbstractComponent abstractComponent;

    public DecoratorComponent(AbstractComponent abstractComponent){
        this.abstractComponent = abstractComponent;
    }


    @Override
    public void display() {
        abstractComponent.display();
    }
}
