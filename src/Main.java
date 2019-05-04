import socket.Server;

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
        try {
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
