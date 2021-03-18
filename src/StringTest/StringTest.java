package StringTest;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/23 22:28
 */
public class StringTest {
    public static void main(String[] args) {
        //https://www.toutiao.com/i6764147718286737932/?group_id=6764147718286737932
        //https://blog.csdn.net/guoxiaolongonly/article/details/80425548
      //  String t2 = "helloworld";//如果t2放到这个前面，那么常量池先有了一个引用，newString的时候就不会往常量池里面放，intern的时候返回的是常量池的引用，和new出来的引用是不一样的
        String t1 = new String("hello")+new String("world");
        t1.intern();
        String t2 = "helloworld";
        System.out.println(t1 == t2);

//        String str3 = new String("计算机");
//        String str1 = "计算机";
//        String str2 = "计算机";
//        System.out.println("str1==str3:" + (str1 == str3));
          //如果第一次出现这个a，先new一个对象放到堆里面，然后字符串常量池存储的是这个对象的引用
//          String t1 = "a";
//          String t2 = "b";
//          String t3 = t1+t2;
//         //String t3 = "a"+"b";
//          String t4 = "ab";
//          System.out.println(t3 == t4);
        //String t1 = "a";
        //如果a是第一次出现的，那么a会在堆里面new一个，然后常量池里面也放一个
        //t2.intern()返回的是常量池里面的那个引用，而t2本身执行的是堆里面创建的对象引用
//        String t2 = new String("a");
//        System.out.println(t2 == t2.intern());
        //调用append方法的这种，第一次不会落到常量池里面，因此t2.intern()的时候，是把t2的引用放到常量池了，所以两边一样
//        String t2 = new String(new StringBuilder("a").append("b").toString());
//        System.out.println(t2.intern() == t2);
    }
}
