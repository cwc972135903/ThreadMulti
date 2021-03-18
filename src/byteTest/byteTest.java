package byteTest;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/5/24 16:48
 */
public class byteTest {
    public static void main(String ...args){
        byte[] bb = new byte[]{0, 1, 1, 1};
        //258 -> 00000001 00000010
        //a ->1-> 00000001 b->2->00000010
        //把a b 两个字节转换位short int
        byte a  = (byte)1;
        byte b = (byte)2;
        //a 左移八位   00000001 00000000
        //和b进行|运算          00000010
        //得到结果：   00000001 00000010 =》 258
        //注意负数的可能不一样，就是符号位1的处理办法
        short i = (short)(a<<8 | b);
        System.out.println(i);

    }
}
