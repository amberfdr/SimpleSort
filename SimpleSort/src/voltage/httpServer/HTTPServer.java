package voltage.httpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * http服务器程序
 */
public class HTTPServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器正在监听端口："+serverSocket.getLocalPort());
            while (true){
                final Socket socket = serverSocket.accept();
                System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为："+socket.getInetAddress()+":"+socket.getLocalPort());
                service(socket);
             }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void service(Socket socket) throws IOException, InterruptedException {
        InputStream socketIn = socket.getInputStream();
        System.out.println("999"+socketIn);
        Thread.sleep(500);
        int size = socketIn.available();
        byte[] buffer = new byte[size];
        socketIn.read(buffer);
        String request = new String(buffer);
        String firstLineOfRequest = request.substring(0,request.indexOf("\r\n"));
        //解析
        String[] parts = firstLineOfRequest.split(" ");
        String uri = parts[1];
        String contentType;
        if(uri.indexOf("html") != -1 || uri.indexOf("htm") != -1){
            contentType = "text/html";
        }else if(uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1){
            contentType = "image/jpeg";
        }else if(uri.indexOf("gif") != -1){
            contentType = "image/gif";
        }else{
            contentType = "application/octet-stream";
        }
        //response
        String responseFirstLine = "HTTP/1.1 200 OK\r\n";
        String responseHeader = "Content-Type:"+contentType+"\r\n\r\n";
        //TODO 返回资源的输入流 "/"开头代表取绝对路径（"/resource" --> "/github/SimpleSort/SimpleSort/out/production/SimpleSort/voltage/httpServer/resource/hello.htm"） 否则 取当前类的相对路径拼接上 （"resource" --> "out/production/SimpleSort/voltage/httpServer/resource/hello.htm"）
        InputStream in = HTTPServer.class.getResourceAsStream("resource/"+uri);
        System.out.println("资源是"+in);
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(responseFirstLine.getBytes());
        socketOut.write(responseHeader.getBytes());
        //发送响应的正文
        int len = 0;
        buffer = new byte[128];
        while ((len = in.read(buffer)) != -1)
            socketOut.write(buffer,0,len);

        Thread.sleep(1000);
        socket.close();
    }
}
