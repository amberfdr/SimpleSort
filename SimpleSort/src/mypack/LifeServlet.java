package mypack;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/14
 * @Version 1.0
 */
public class LifeServlet extends HttpServlet {
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
    private String name ;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getServletName();
        initVar++;
        System.out.println(name+"Servlet容器被初始化了"+initVar+"次");
    }

    @Override
    public  void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
        serviceVar++;
        System.out.println(name+"Servlet容器被了访问了"+serviceVar+"次");
        String content1 = "初始化次数："+initVar;
        String content2 = "响应客户端次数："+serviceVar;
        String content3 = "销毁次数："+destroyVar;
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>LifeServlet</title></head>");
        out.println("<body>");
        out.println("<h1>"+content1+"</h1>");
        out.println("<h1>"+content2+"</h1>");
        out.println("<h1>"+content3+"</h1>");
        out.println("</body></html>");
        out.close();
    }
    @Override
    public void destroy(){
        destroyVar++;
        System.out.println(name+"Servlet容器被销毁了"+initVar+"次");

    }
}
