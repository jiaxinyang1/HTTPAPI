package http;

/**
 * HttpHandle
 * 处理请求
 * @author hakurei
 * @date 2019/5/4
 */
public class HttpHandle implements Http {

    private  Request request;
    private  Response response;



    @Override
    public String getData(String data) {


        this.request= new Request(data);
        this.response= new Response();
        String url =this.request.getUrl();
        if (url!=null){
            String res= Router.getRoute().func(url).exec();

            response.setBody(res);


            // 路由转发处理
            // 构造请求数据

        }

        return  response.responseData();
    }


}
