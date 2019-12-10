package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Describe: 过滤器类，能够对NoteServlet生成的响应结果进行字符串替换
 *
 * @Author fuderong
 * @Date 2019/12/9
 * @Version 1.0
 */
public class ReplaceTextFilter implements Filter {
    /**
     * 过滤器的配置
     */
    private FilterConfig config = null;
    private String searchStr = null;
    private String replaceStr = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ReplaceTextWrapper replaceTextWrapper = new ReplaceTextWrapper(servletResponse,searchStr,replaceStr);
        filterChain.doFilter(servletRequest,replaceTextWrapper);
        replaceTextWrapper.getOutputStream().close();
    }

    @Override
    public void destroy() {

    }
}
