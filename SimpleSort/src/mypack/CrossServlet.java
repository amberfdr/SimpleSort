package mypack;

import javax.servlet.*;
import java.io.IOException;

/**
 * Describe: 一个web应用访问另一个web应用
 *
 * @Author fuderong
 * @Date 2019/11/25
 * @Version 1.0
 */
public class CrossServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String message = null;
        if(username != null){
            message = "Hello "+username;
        }else{
            message = "Please input username";
        }
        servletRequest.setAttribute("msg",message);
        // 获取当前应用的ServletContext对象
        ServletContext context = getServletContext();
        // 获得helloapp应用的ServletContext对象
        ServletContext crossContext = context.getContext("/helloapp");
        RequestDispatcher dispatcher = crossContext.getRequestDispatcher("/output");
        // 把请求转发给helloapp应用的outputServlet
        dispatcher.forward(servletRequest,servletResponse);
    }
}
