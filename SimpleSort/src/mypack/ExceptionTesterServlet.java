package mypack;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/18
 * @Version 1.0
 */
public class ExceptionTesterServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String condition = req.getParameter("condition");
        if(condition == null){
            condition = "ok";
        }
        if("1".equals(condition)){
            throw new ServletException("condition1");
        }else if("2".equals(condition)){
            //servlet在2秒内不能被访问
            throw new UnavailableException("condition2",2);
        }else if("3".equals(condition)){
            //servlet永远不被访问
            throw new UnavailableException("condition3");
        }
        PrintWriter out = res.getWriter();
        out.println("It's OK");
        out.close();
    }
}
