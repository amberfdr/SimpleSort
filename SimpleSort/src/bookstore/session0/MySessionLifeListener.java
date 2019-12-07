package bookstore.session0;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/12/6
 * @Version 1.0
 */
public class MySessionLifeListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Attribute("+httpSessionBindingEvent.getName()+","+httpSessionBindingEvent.getValue()+")被添加到一个session中");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Attribute("+httpSessionBindingEvent.getName()+","+httpSessionBindingEvent.getValue()+")被删除到一个session中");

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Attribute("+httpSessionBindingEvent.getName()+","+httpSessionBindingEvent.getValue()+")被替换到一个session中");

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个新的session被创建");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("一个新的session被销毁");
    }
}
