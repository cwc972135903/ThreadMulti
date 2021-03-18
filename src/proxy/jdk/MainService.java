package proxy.jdk;


import java.lang.reflect.Proxy;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/6/14 12:54
 */
public class MainService {
    public static void main(String[] args) {
        TargetService targetService = new TargetService();
        //可以把invocationHandle单独拿出去，然后把targetService通过set方法传进去
      ParentService ps = (ParentService) Proxy.newProxyInstance(targetService.getClass().getClassLoader(), targetService.getClass().getInterfaces(), (object, method, args1) -> {
            String res = "";
            if(method.getName().equals("getName")){
                System.out.println("before========");
                res = (String) method.invoke(targetService, args1);
                System.out.println("after========");
            }

            return res;
        });

        System.out.println(ps.getName());

    }
}
