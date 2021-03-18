package DesignPattern.Strategy.MeiTStrategy;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 18:59
 */
public class MainStrategy {
    public static void main(String ...args) throws UnsupportedEncodingException {
//        ConcreteFactory concreteFactory = new ConcreteFactory();
//
//        RewardStartegy rewardStartegy = concreteFactory.createStrategy(ConcreteStrategy.class);
//
//        ContextStrategy contextStrategy = new ContextStrategy(rewardStartegy);
//        contextStrategy.doSth(123);
        String a = "中";
        System.out.println(a.getBytes("UTF-8"));



    }
}
