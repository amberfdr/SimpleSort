package bookstore.session0;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/12/6
 * @Version 1.0
 */
public class OnlineCounterListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer counter = (Integer)servletContext.getAttribute("counterSession");
        if(counter == null){
            counter = new Integer(1);
        }else{
            counter = new Integer(counter+1);
            System.out.println("counter:"+counter);
        }
        servletContext.setAttribute("counterSession",counter);
        session.setMaxInactiveInterval(60);
        System.out.println("一个session是被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer counter = (Integer)servletContext.getAttribute("counterSession");
        if(counter == null){
            return;
        }else{
            counter = new Integer(counter-1);
        }
        servletContext.setAttribute("counterSession",counter);
        session.setMaxInactiveInterval(60);
        System.out.println("一个session是被销毁");
    }
}
