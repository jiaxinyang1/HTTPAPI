package http;

import java.util.HashMap;
import java.util.Map;

/**
 * Router
 * 构造路由转发
 * @author hakurei
 * @date 2019/5/4
 */
public class Router {

    private static volatile Router route;
    private Map<String,Command> router;

    private   Router(){
        this.router=new HashMap<>();
    }

    public static Router getRoute(){
        if (route==null) {
            synchronized (Router.class){
                if (route==null){
                    route= new Router();
                }
            }

        }
        return  route;
    }
    /**
     * 添加路由
     * @param url
     * @param func
     */
    public  void add(String url,Command func){
        router.put(url,func);
    }

    /**
     * 根据对应路由返回对应
     * @param url
     * @return
     */
    public Command func(String url){
       return   router.get(url);
    }

}
