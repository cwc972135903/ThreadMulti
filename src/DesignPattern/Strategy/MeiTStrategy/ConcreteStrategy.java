package DesignPattern.Strategy.MeiTStrategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 18:46
 */
public class ConcreteStrategy extends RewardStartegy {
    @Override
    public void reward(long userId) {
        System.out.println("rewared:" + userId);
    }
}
