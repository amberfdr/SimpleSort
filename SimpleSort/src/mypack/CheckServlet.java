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
 * Describe: 负责检查信息，转发
 *
 * @Author fuderong
 * @Date 2019/11/22
 * @Version 1.0
 */
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String message = null;
        if(username != null){
            message = "Hello "+username;
        }else{
            message = "Please input username";
        }
        req.setAttribute("msg",message);
        ServletContext context = getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/output");
        PrintWriter out = resp.getWriter();
        // 在转发以前检查
        out.println("在转发以前检查");
        System.out.println("在转发以前检查");
        requestDispatcher.forward(req,resp);
        out.println("在转发后检查");
        System.out.println("在转发后检查");
    }
}
