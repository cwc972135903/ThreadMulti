package ThreadDemo1;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2019/12/15 20:51
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0; i<=500000000; ++i){
                if(this.isInterrupted()){
                    System.out.println("已经是停止状态了，我要退出线程");
                    throw new InterruptedException();
                }
                System.out.println("i="+i);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
