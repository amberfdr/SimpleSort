package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/13
 * @Version 1.0
 */
public class ContextTesterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>ContextTesterServlet</title></head>");
        out.println("<body>");
        out.println("<br> Email:"+context.getInitParameter("emailOfwebmaster"));
        out.println("<br> Path:"+context.getRealPath("/WEB-INF"));
        out.println("<br> MimeType:"+context.getMimeType("/WEB-INF/web.xml"));
        out.println("<br> MajorVersion:"+context.getMajorVersion());
        out.println("<br> ServerInfo:"+context.getServerInfo());
        out.println("</body></html>");
        //输出日志
        context.log("这是ContextTesterServlet输出的日志");
        out.close();
    }
}
