package mypack;

import javax.servlet.*;
import java.io.IOException;

public class DispatcherServlet extends GenericServlet {
    private String target = "/hello.jsp";
    /*响应客户请求*/
    @Override
    public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException {
        //读取表单中的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //在request对象中添加USER、PASSWORD属性
        request.setAttribute("USER",username);
        request.setAttribute("PASSWORD",password);

        /* 把请求转发给hello.jsp */
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request,response);
    }

}
