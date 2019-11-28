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
 * @Date 2019/11/21
 * @Version 1.0
 */
public class ImageCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Counter counter = (Counter)context.getAttribute("counter");
        if(counter == null){
            counter = new Counter(1);
            context.setAttribute("counter",counter);
        }
        resp.setContentType("text/html;charset=GB2312");
        PrintWriter out = resp.getWriter();
        out.println("<html><head>ImageCounterServlet</head>");
        out.println("<body>");
        String imageLink = "<img src= 'image?count="+counter.getCount()+"'/>";
        out.println("欢迎光临本站，您是第"+imageLink+"位访问者");
        out.println("</body></html>");
        // 将计数器递增
        counter.add(1);
        out.close();
    }
}
