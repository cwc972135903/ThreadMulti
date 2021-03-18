package proxy.cglib;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2021/2/8 14:34
 */
public class TargetService {
    public TargetService(){
        System.out.println("HelloService构造");
    }

    final public String sayOthers(String name){
        System.out.println("HelloService.sayOthers:" + name);
        return "";
    }

    public void sayHello(){
        System.out.println("HelloService.sayHello");
    }


}
