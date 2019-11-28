package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Describe:测试tomcat的工作目录
 *
 * @Author fuderong
 * @Date 2019/11/22
 * @Version 1.0
 */
public class DirTesterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        resp.setContentType("text/html;charset=GB2312");
        PrintWriter out = resp.getWriter();
        Enumeration<String> eu = context.getAttributeNames();
        while(eu.hasMoreElements()){
            String atrributename = eu.nextElement();
            out.println("<br>"+atrributename+":"+context.getAttribute(atrributename));
        }
        out.close();
        // 获得工作目录属性
        File workDir = (File)context.getAttribute("javax.servlet.context.tempdir");
        // 在工作目录下生成一个文件
        FileOutputStream outputStream = new FileOutputStream(workDir+"/temp.txt");
        outputStream.write("Hello world".getBytes());
        outputStream.close();
    }
}
