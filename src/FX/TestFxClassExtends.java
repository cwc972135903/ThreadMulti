package FX;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/3/26 11:19
 */
public class TestFxClassExtends {
    public static void main(String ...args){
        Father<Integer,String> father = new child<>(1, "2");
        child<String,String ,Boolean> child = new child<>("1","2");
    }
}

class Father<T1, T2>{
    T1 t1;
    T2 t2;
    public Father(T1 t1, T2 t2){
        this.t1 = t1;
        this.t2 = t2;
        System.out.println(this.t1.getClass());
        System.out.println(this.t2.getClass());
    }
}

/**
 * 子类的泛型可以比父类泛型多
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
class child<T1, T2, T3> extends Father<T1, T2>{

    public child(T1 t1, T2 t2) {
        super(t1, t2);
    }
}
/**
 * 子类继承的时候 可以指定某一个泛型的类型, 这样子类泛型可以比父类泛型少
 *
 * @param <T1>
 */
class child1<T1> extends Father<T1, String>{

    public child1(T1 t1, String t2) {
        super(t1, t2);
    }
}