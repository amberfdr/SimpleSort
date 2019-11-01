package voltage.httpServer.servlet;

import java.io.OutputStream;

public class HelloServlet implements Servlet {
    @Override
    public void init() throws Exception {
        System.out.println("HelloServlet is inited");
    }

    @Override
    public void service(byte[] requestBuffer, OutputStream out) throws Exception {
        String request = new String(requestBuffer);
        //获取HTTP请求的第一行
        String firstLineOfRequest = request.substring(0,request.indexOf("\r\n"));
        //解析HTTP请求的第一行
        String[] parts = firstLineOfRequest.split(" ");
        String method = parts[0];
        String uri = parts[1];
        //获取请求参数username
        String username = null;
        //拼接get 和 post请求的参数
        if(method.equalsIgnoreCase("get") && uri.indexOf("username") != -1){
            // servlet/HelloServlet?username=tom&password=123456
            //parameters = username=tom&password=123456
            String parameters = uri.substring(uri.indexOf("?"),uri.length());
            parts = parameters.split("&");
            parts = parts[0].split("=");
            username = parts[1];

        }

        //post请求
        if(method.equalsIgnoreCase("post")){
            int locate = request.indexOf("\r\n\r\n");
            //获得响应正文
            String content = request.substring(locate+4,request.length());
            if(content.indexOf("username") != -1){
                parts = content.split("&");
                parts = parts[0].split("=");
                username = parts[1];
            }
        }

        //创建并发送HTTP响应
        //HTTP响应第一行
        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        //HTTP响应头
        out.write("ContentType:text/html\r\n\r\n".getBytes());
        //HTTP响应正文
        out.write("<html><head>hello world</head><body>".getBytes());
        out.write(new String("<h1>Hello:"+username+"</h1></body></html>").getBytes());
    }
}
