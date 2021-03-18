package FX;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/2 9:40
 */
public class TestFXMethod {
    public static void main(String[] args) {
        //不能在Java中创建泛型数组类型的原因是什么:https://blog.csdn.net/aabbwoshishei/article/details/50163261
        //List<String>[] ls = new ArrayList<String>[10];

    }

    /**
     * 泛型方法的基本介绍:https://www.cnblogs.com/coprince/p/8603492.html
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }
}
