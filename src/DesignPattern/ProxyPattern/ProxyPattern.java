package DesignPattern.ProxyPattern;

import DesignPattern.ProxyPattern.Simple.AbstractSubject;
import DesignPattern.ProxyPattern.Simple.ProxySubject;
import DesignPattern.ProxyPattern.Simple.RealSubject;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/22 16:47
 */
public class ProxyPattern {
    public static void main(String ...args){
        AbstractSubject abstractSubject = new ProxySubject(new RealSubject());
        abstractSubject.request();
    }
}
