package http;

/**
 * Http
 * 抽象接口，作为连接Socket 和HTTP 上下层的接口
 * @author hakurei
 * @date 2019/5/4
 */
public interface Http {

    /**
     * 返回响应数据
     * @author hakurei
     * @date 16:50 2019/5/4
     * @param data
     * @return  响应数据
     **/
     String getData(String data);
}
