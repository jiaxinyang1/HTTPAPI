package http;

import java.util.HashMap;
import java.util.Map;

/**
 * Response
 * 响应头
 * @author hakurei
 * @date 2019/5/4
 */
public class Response {

    private  String header;
    private  Map<String,String> head;
    private  String body;
    public Response(){
        this.head=new HashMap<>();
        this.buildHeader();

    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @author hakurei
     * 构造响应头
     * @date 16:28 2019/5/4
     **/
    private void buildHeader(){
        StringBuilder stringBuilder =new StringBuilder();

        stringBuilder.append("Http/1.1 200 Ok\r\n");
        head.put("Content-Type","text/html,application/json;charset=UTF-8");
        for (Map.Entry<String,String> entry :
                head.entrySet()) {
            stringBuilder.append(entry.getKey()+":"+entry.getValue()+"\r\n");

        }
        stringBuilder.append("\r\n");
        header=stringBuilder.toString();

    }

    public String responseData(){
        this.body="{\"abc\":\"123456\"}";
        return header+body;
    }


}
