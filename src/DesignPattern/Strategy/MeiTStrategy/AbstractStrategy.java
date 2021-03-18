package DesignPattern.Strategy.MeiTStrategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 18:48
 */
public abstract class AbstractStrategy {
    abstract  RewardStartegy createStrategy(Class className);
}
