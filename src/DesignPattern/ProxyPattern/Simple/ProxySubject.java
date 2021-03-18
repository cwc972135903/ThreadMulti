package DesignPattern.ProxyPattern.Simple;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 17:19
 */
public class ProxySubject extends AbstractSubject {
    private AbstractSubject abstractSubject;

    public ProxySubject(AbstractSubject abstractSubject){
        this.abstractSubject = abstractSubject;
    }

    @Override
    public void request() {
        this.preRequest();
        abstractSubject.request();
        this.afterRequest();
    }

    /**
     * 前置方法
     */
    public void preRequest(){
        System.out.println("preRequest");
    }

    /**
     * 后置方法
     */
    public void afterRequest(){
        System.out.println("afterRequest");
    }
}
