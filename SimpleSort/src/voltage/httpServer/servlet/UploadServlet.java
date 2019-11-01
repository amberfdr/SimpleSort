package voltage.httpServer.servlet;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.StringReader;

public class UploadServlet implements Servlet {
    @Override
    public void init() throws Exception {
        System.out.println("UploadServlet is inited");
    }

    @Override
    public void service(byte[] requestBuffer, OutputStream out) throws Exception {
        String request = new String(requestBuffer);

        String headerOfRequest = request.substring(request.indexOf("\r\n")+2,request.indexOf("\r\n\r\n"));
        //TODO 这儿为什么这样读取？
        BufferedReader br = new BufferedReader(new StringReader(request));
        String data = null;
        //获取boundary
        String boundary = null;
        while((data = br.readLine())!= null){
            if(data.indexOf("Content-Type")!= -1){
                boundary = data.substring(data.indexOf("boundary=")+9,data.length())+"\r\n";
                break;
            }
        }
        if(boundary == null){
           out.write("HTTP/1.1 200 OK\r\n".getBytes());
           //发送HTTP响应头
            out.write("Content-Type:text/html\r\n\r\n".getBytes());
            //发送HTTP响应正文
            out.write("Upload failed".getBytes());
            return;
        }

        //第一个boundary 出现的位置
        int index1OfBoundary = request.indexOf(boundary);
        //第二个boundary 出现的位置
        int index2OfBoundary = request.indexOf(boundary,index1OfBoundary+boundary.length());
        //第三个boundary 出现的位置
        int index3OfBoundary = request.indexOf(boundary,index2OfBoundary+boundary.length());
        //文件部分开始的位置
        int beforeOfFilePart = request.indexOf("\r\n\r\n",index2OfBoundary)+3;
        //文件部分结束的位置
        int afterOfFilePart = index2OfBoundary-4;

    }
}
