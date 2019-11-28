package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:读写cookie
 *
 * @Author fuderong
 * @Date 2019/11/21
 * @Version 1.0
 */
public class CookieServlet extends HttpServlet {
    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                out.println("Cookie name:"+cookie.getName());
                out.println("Cookie value:"+cookie.getValue());
                out.println("Max Age:"+cookie.getMaxAge());
            }
        }else{
            out.println("No cookies");
        }
        // 向客户端写一个cookie
        resp.addCookie(new Cookie("cookiename"+count,"cookievalue"+count));
        count++;
    }
}
