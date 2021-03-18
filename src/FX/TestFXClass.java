package FX;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/2 9:17
 */
public class TestFXClass<T> {

    private T name;

    public TestFXClass(T name){
        this.name = name;
    }
    public T getName() {
        return name;
    }

}
