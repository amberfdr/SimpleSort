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
public class CounterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Counter counter = (Counter)context.getAttribute("counter");
        if(counter == null){
            counter = new Counter(1);
            context.setAttribute("counter",counter);
        }
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>ContextTesterServlet</title></head>");
        out.println("<body>");
        out.println("<h1> 欢迎光临本站。您是第"+counter.getCount()+"位访问者</h1>");
        out.println("</body></html>");

        counter.add(1);
        out.close();
    }
}
