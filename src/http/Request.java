package http;

import java.util.HashMap;
import java.util.Map;

/**
 * Request
 * http 请求头解析
 * @author hakurei
 * @date 2019/5/4
 */
public class Request {


    private String header;
    private String requestData;
    private String method;
    private Map params;
    private String url;
    private String body;
    public Request(String  requestData){

        this.params=new HashMap(16);
        this.requestData=requestData;
    }
    /**
     * @author hakurei
     *  解析请求头，分离头部信息
     * @date 15:25 2019/5/4
     **/
    public void parse(){

        // 分割请求头和body
        String [] data =requestData.split("\r\n\r\n");
        if (data[0].length()>0){
            header=data[0];
            parseHeader();
        }
        if (data.length>1&& data[1].length()>0){
            body=data[1];
        }
    }
    /**
     * @author hakurei
     *  解析头部
     * @date 16:07 2019/5/4
     **/
    private void parseHeader(){

        String[] head =header.split("\r\n");
        //解析第一行 方法， url 和params
        if (head[0].length()>0){
            String []first =head[0].split(" ");
            this.method= first[0];
            parseUrl(first[1]);
            parseParams(first[1]);
        }
    }
    /**
     * @author hakurei
     *  分割出路径
     * @date 15:52 2019/5/4
     **/
    private void  parseUrl(String str){
        if (!str.contains("?")){
            this.url=str;
        }else {
            this.url=str.split("\\?")[0];
        }
    }
    /**
     * @author hakurei
     *  分割参数
     * @date 15:49 2019/5/4
     **/
    private void parseParams(String str){
        if (str.length()==0){
            return;
        }
        if (!str.contains("?")){
            return;
        }
        str=str.split("\\?")[1];
        String[] p=str.split("&");
        for (String s :
                p) {
            String []par = s.split("=");
            this.params.put(par[0],par[1]);
        }
    }


}
