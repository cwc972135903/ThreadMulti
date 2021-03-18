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
public class RealSubject extends AbstractSubject {
    @Override
    public void request() {
        System.out.println("request data......");
    }
}
