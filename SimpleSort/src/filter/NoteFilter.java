package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:留言簿过滤器
 *
 * @Author fuderong
 * @Date 2019/12/7
 * @Version 1.0
 */
public class NoteFilter implements Filter {
    /**
     * 过滤器的配置
     */
    private FilterConfig config = null;
    private String blackList = null;
    private String ipblock = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("NoteFilter : init()");
        // 把Servlet容器提供的FilterConfig对象传给config成员变量
        this.config = filterConfig;
        // 读取ipBlock 的初始化参数
        ipblock = config.getInitParameter("ipblock");
        // 读取blackList初始化参数
        blackList = config.getInitParameter("blacklist");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("NoteFilter: doFilter()");
        // 在拒绝的ip地址范围内
        if(!checkRemoteIp(servletRequest,servletResponse)){
            return;
        }
        // 在黑名单内
        if(!checkUserName(servletRequest,servletResponse)){
            return;
        }
        // 记录响应客户请求前的时间
        long before = System.currentTimeMillis();
        config.getServletContext().log("NoteFilter: before call chain.doFilter()");
        System.out.println("NoteFilter: before call chain.doFilter()");

        // 把请求转发给后续的过滤器和web组件
        filterChain.doFilter(servletRequest,servletResponse);
        // 记录响应客户请求后的时间
        config.getServletContext().log("NoteFilter: after call chain.doFilter()");
        System.out.println("NoteFilter: after call chain.doFilter()");
        long after = System.currentTimeMillis();
        String name = "";
        if(servletRequest instanceof HttpServletRequest){
            name = ((HttpServletRequest) servletRequest).getRequestURI();
        }

        // 记录响应客户请求所花的时间
        config.getServletContext().log("NoteFilter:"+name+":"+(after-before)+"ms");
    }

    @Override
    public void destroy() {
        System.out.println("NoteFilter: destroy()");
        config = null;
    }
    private boolean checkRemoteIp(ServletRequest request,ServletResponse response) throws IOException {
        // 读取客户的ip地址
        String remoteAddr = request.getRemoteAddr();
        if(remoteAddr.indexOf(ipblock) == 0){
            response.setContentType("text/html;charset=GB2312");
            PrintWriter out = response.getWriter();
            out.println("<h1>对不起，服务器无法为你提供服务</h1>");
            out.flush();
            return false;
        }else{
            return true;
        }
    }
    private boolean checkUserName(ServletRequest request,ServletResponse response) throws IOException {
        String username = request.getParameter("username");
        if(username != null){
            username = new String(username.getBytes("ISO-8859-1"),"GB2312");
        }
        if(username != null && username.indexOf(blackList) != -1){
            // 生成拒绝用户留言的网页
            response.setContentType("text/html;charset=GB2312");
            PrintWriter out = response.getWriter();
            out.println("<h1>对不起，"+username+"你没有权限留言</h1>");
            out.flush();
            return false;
        }else{
            return true;
        }
    }

}
