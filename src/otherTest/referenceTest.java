package otherTest;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/17 21:06
 */
public class referenceTest {
    private String name;
    public referenceTest(){

    }
    public referenceTest(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        A a = new A("123");

    }
}

class A extends referenceTest{
    public A(String name){
        super(name);
    }
}
