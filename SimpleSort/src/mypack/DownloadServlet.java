package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/18
 * @Version 1.0
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出响应正文的输出流
        OutputStream out;
        //读取本地文件的输入流
        InputStream in;
        String filename = req.getParameter("filename");
        if(filename == null){
            out = resp.getOutputStream();
            out.write("Please input filename".getBytes());
            out.close();
        }
        //获得读取本地文件的输出流
        in = getServletContext().getResourceAsStream("/store/"+filename);
        int length = in.available();
        //设置响应正文的MINE类型
        resp.setContentType("application/force-download");
        resp.setHeader("Content-Length",String.valueOf(length));
        resp.setHeader("Content-Disposition","attachement;filename\""+filename+"\"");
        //把本地文件中的数据发送给客户
        out = resp.getOutputStream();
        int bytesRead = 0;
        byte[] buffer = new byte[512];
        while((bytesRead = in.read(buffer)) != -1){
            out.write(buffer,0,bytesRead);
        }
        in.close();
        out.close();
    }
}
