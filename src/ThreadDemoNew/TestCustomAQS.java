package ThreadDemoNew;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/3/18 17:35
 */
public class TestCustomAQS implements Lock {
    private LockHelper lockHelper = new LockHelper();

    @Override
    public void lock() {
        lockHelper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        lockHelper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return lockHelper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return lockHelper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        lockHelper.release(1);
    }

    @Override
    public Condition newCondition() {
        return lockHelper.newCondition();
    }

    class LockHelper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {

            // 如果第一个线程进来，可以拿到锁，因此我们可以返回true

            // 如果第二个线程进来，则拿不到锁，返回false。有种特例，如果当前进来的线程和当前保存的线程是同一个线程，则可以拿到锁，但是有代价，要更新状态值

            // 如何判断是第一个线程进来还是其他线程进来？
            //获取状态值
            int state = getState();
            Thread t = Thread.currentThread();
            //如果状态=0，那就是第一个线程
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    //设置当前线程为独占锁线程
                    setExclusiveOwnerThread(t);
                    return true;
                }
            } else if (getExclusiveOwnerThread() == t) {
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            // 锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            //获取当前线程,如果不等于独占锁的线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }

            int state = getState() - arg;

            boolean flag = false;

            if (state == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);

            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }

    }
}
