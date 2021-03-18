package DesignPattern.AdapterPattern;

/**
 * <p>Title: xCRMS </p>
 * Description: 适配器对象<br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 15:49
 */
public class Adapter implements Target {
    private Adaptee adaptee;
    public  Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.sRequest();
    }
}
