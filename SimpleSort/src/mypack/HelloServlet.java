package mypack;

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
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if(username != null) {
            username = new String(username.getBytes("ISO-8859-1"),"utf-8");
        }
        if(username == null){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return ;
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>HelloServlet</title></head>");
        out.println("<body>");
        out.println("你好："+username);
        out.println("</body></html>");
        System.out.println("before close():"+response.isCommitted());
        out.close();
        System.out.println("after close():"+response.isCommitted());

    }
}
