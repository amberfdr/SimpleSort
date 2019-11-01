package voltage.httpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * http客户程序
 */
public class HTTPClient {

    public static void main(String[] args) {
        String uri = "index.htm";
        if(args.length != 0) uri = args[0];
        doGet("localhost",8080,uri);
    }

    public static void doGet(String host,int port,String uri){
        Socket socket = null;
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer("GET "+uri+" HTTP/1.1\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("Accept-Language: zh-cn\r\n");
        sb.append("User-Agent: HTTPClient\r\n");
        sb.append("Host: localhost:8080\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");

        OutputStream socketOut = null;
        try {
            socketOut = socket.getOutputStream();
            socketOut.write(sb.toString().getBytes());
            Thread.sleep(2000);

            InputStream socketIn = socket.getInputStream();
            int size = socketIn.available();
            byte[] buffer = new byte[size];
            socketIn.read(buffer);
            System.out.println(new String(buffer));
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
