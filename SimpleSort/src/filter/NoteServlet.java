package filter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Describe:留言簿
 *
 * @Author fuderong
 * @Date 2019/12/7
 * @Version 1.0
 */
public class NoteServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("NoteServlet: service()");
        resp.setContentType("text/html;charset=GB2312");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>留言簿</title></head>");
        out.println("<body>");
        String username = req.getParameter("username");
        String content = req.getParameter("content");

        if(username != null){
            username = new String(username.getBytes("ISO-8859-1"),"GB2312");
        }
        if(content != null){
            content = new String(content.getBytes("ISO-8859-1"),"GB2312");
        }
        if(content != null && !content.equals("")){
            out.println("<p>"+username+"   的留言为   "+content+"</p>");
        }

        out.println("<form action="+req.getContextPath()+"/note method=post>");
        out.println("姓名:");
        out.println("<input name=username type=text />");

        out.println("留言:");
        out.println("<textarea name=content rows=5 cols=20 ></textarea>");
        out.println("<input type='submit' value='提交'/>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
