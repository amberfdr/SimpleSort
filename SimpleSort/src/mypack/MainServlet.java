package mypack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:包含
 *
 * @Author fuderong
 * @Date 2019/11/22
 * @Version 1.0
 */
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;GB2312");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>MainServlet</title></head><body>");
        ServletContext context = getServletContext();
        RequestDispatcher headerDispatcher = context.getRequestDispatcher("/header.htm");
        RequestDispatcher greetDispatcher = context.getRequestDispatcher("/greet");
        RequestDispatcher footerDispatcher = context.getRequestDispatcher("/footer.htm");
        headerDispatcher.include(req,resp);
        greetDispatcher.include(req,resp);
        footerDispatcher.include(req,resp);
        out.println("</body></html>");
        out.close();
    }
}
