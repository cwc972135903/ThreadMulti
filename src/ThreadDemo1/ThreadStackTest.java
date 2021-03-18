package ThreadDemo1;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 1. 虚拟机栈-》栈帧，每个栈帧越大，能创建的线程数量就越少了，因为总的栈大小在虚拟机初始化的时候就固定好了
 * 2. stacksize代表当前线程占用的stack大小，默认不传的话，是0，代表着会忽略该参数，该参数会被jni函数使用；该参数在一些平台无效；最好不需要显示指定
 *    通过-xss10m（vm options）去指定即可
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/1/5 14:56
 */
public class ThreadStackTest {
    public static void main(String... args){

    }
}
