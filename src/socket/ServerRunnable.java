package socket;

import http.Http;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * ServerRunnable
 *
 * @author hakurei
 * @date 2019/5/4
 */
public class ServerRunnable implements Runnable {

    private  SocketChannel socketChannel;
    private  StringBuilder stringBuilder;
    private Http httpHandle;

    public ServerRunnable(SocketChannel socketChannel,Http httpHandle){

        this.socketChannel=socketChannel;
        this.httpHandle=httpHandle;

    }
    @Override
    public void run() {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            stringBuilder =new StringBuilder();
            buf.clear();
            int len =socketChannel.read(buf);
            while (len>0)
            {
                buf.flip();
                while (buf.position()<buf.limit())
                {
                    stringBuilder.append((char)buf.get());
                }
                if(buf.limit()<buf.capacity())
                {
                    break;
                }
                buf.clear();
                len = socketChannel.read(buf);
            }
            buf.clear();

            String response= httpHandle.getData(stringBuilder.toString());
            buf=ByteBuffer.wrap(response.getBytes("UTF-8"));
            socketChannel.write(buf);
            socketChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());

    }


}
