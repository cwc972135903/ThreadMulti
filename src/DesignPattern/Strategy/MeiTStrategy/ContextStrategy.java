package DesignPattern.Strategy.MeiTStrategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 18:57
 */
public class ContextStrategy {
    private RewardStartegy rewardStartegy;

    public ContextStrategy(RewardStartegy rewardStartegy){
        this.rewardStartegy = rewardStartegy;
    }

    public void doSth(int userId){
        rewardStartegy.reward(userId);
        rewardStartegy.insertRewardAndSettlement(userId, 1122);
    }
}
