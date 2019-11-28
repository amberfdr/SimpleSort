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
public class CounterClearServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.removeAttribute("counter");
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("The counter is ");
        out.close();
    }


}
