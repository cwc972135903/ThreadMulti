package DesignPattern.Strategy.MeiTStrategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 18:50
 */
public class ConcreteFactory extends AbstractStrategy {
    @Override
    RewardStartegy createStrategy(Class className) {
        RewardStartegy product = null;
        try {
            product = (RewardStartegy) Class.forName(className.getName()).newInstance();
        } catch (Exception e) {}
        return product;
    }

}
