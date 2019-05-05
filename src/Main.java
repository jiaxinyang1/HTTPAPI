import http.HttpHandle;
import http.Router;
import socket.Server;
import socket.ServerRunnable;

import java.io.IOException;

/**
 * Main
 *
 * @author hakurei
 * @date 2019/5/4
 */
public class Main {

    public static void main(String []args){
        Server server = new Server();
        server.setHttpHandle(new HttpHandle());
        Router.getRoute().add("/music",()->{
            String data ="{\"music\":\"i am music\" }";
            return data;
        });
        Router.getRoute().add("/user",()->{
            String data ="{\"user\":\"i am user\" }";
            return data;
        });
        try {
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
