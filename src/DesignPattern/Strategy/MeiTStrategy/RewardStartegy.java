package DesignPattern.Strategy.MeiTStrategy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/4/27 17:11
 */
public abstract class RewardStartegy {
    public abstract void reward(long userId);

    public void insertRewardAndSettlement(long userId, int reward) {
        System.out.println("userid:"+userId+"--reward:"+reward);
    } ; //更新用户信息以及结算
}
