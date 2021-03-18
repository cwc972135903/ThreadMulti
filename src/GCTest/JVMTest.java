package GCTest;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/3/26 21:46
 */
public class JVMTest {
    public static void main(String ...args){
        int i  = 1000;
        //先执行iload指令，这时候在增加的时候，加的是局部变量表的值，又把istore回去的时候，还是1000
        //i = i++;
        //先执行iinc命令，这时候局部变量表的值已经变成1001，
        //然后执行iload，istore，最后的值变了1001
//        i = ++i;
//        System.out.println(i);
        GCRootDemo gcRootDemo = new GCRootDemo();
    }
}
class GCRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];

    private static GCRootDemo gc2;
    private static final GCRootDemo gc3 = new GCRootDemo();

    public static void m1() {
        GCRootDemo gc1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}