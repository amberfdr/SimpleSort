package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:负责响应信息
 *
 * @Author fuderong
 * @Date 2019/11/22
 * @Version 1.0
 */
public class Output1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = (String)req.getAttribute("msg");
        PrintWriter out = resp.getWriter();
        out.println("before msg:"+msg);
        msg = req.getParameter("msg");
        out.println("after msg:"+msg);
        out.close();
    }
}
