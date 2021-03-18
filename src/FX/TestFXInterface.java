package FX;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/2 9:26
 */
public interface TestFXInterface<T> {
    void handle(T t);
}

/**
 * 如果接口指定了泛型类型， 类也要指定
 * @param <T>
 */
class Test<T> implements TestFXInterface<T>{

    @Override
    public void handle(T o) {

    }
}

/**
 * 如果接口直接指定了实际的类型，那么类里面的相关参数也要指定对应的类型
 */
class Test1 implements TestFXInterface<String>{

    @Override
    public void handle(String o) {

    }
}
