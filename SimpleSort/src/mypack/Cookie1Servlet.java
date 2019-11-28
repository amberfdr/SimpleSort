package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:修改或删除Cookie
 *
 * @Author fuderong
 * @Date 2019/11/21
 * @Version 1.0
 */
public class Cookie1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("username")){
                    cookie = c;
                }
            }
        }else{
            out.println("No cookies");
        }
        if(cookie == null){
            cookie = new Cookie("username","Tom");
            // 客户端在本地硬盘上保存的时间位1个小时
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
        }else if(cookie.getValue().equals("Tom")){
            cookie.setValue("Jack");
            resp.addCookie(cookie);
        }else if(cookie.getValue().equals("Jack")){
            // 删除该cookie
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }
}
