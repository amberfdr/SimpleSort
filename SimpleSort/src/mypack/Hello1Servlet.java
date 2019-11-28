package mypack;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe: 并发问题
 *
 * @Author fuderong
 * @Date 2019/11/26
 * @Version 1.0
 */
public class Hello1Servlet extends GenericServlet {
    private String username = null;
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        username = servletRequest.getParameter("username");
        if(username != null){
            username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        servletResponse.setContentType("text/html;charset=GB2312");
        PrintWriter out = servletResponse.getWriter();
        out.println("<html><head><title></title></head><body>");
        out.println("你好，"+username);
        out.println("</body></html>");
        out.close();

    }
}
