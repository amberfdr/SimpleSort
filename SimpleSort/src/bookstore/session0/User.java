package bookstore.session0;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Describe: 表示用户
 *
 * @Author fuderong
 * @Date 2019/12/6
 * @Version 1.0
 */
public class User implements HttpSessionBindingListener {
    private OnlineUsers onlineUsers = OnlineUsers.getInstance();
    private String name = null;

    public User(String name) {
        this.name = name;
    }

    public OnlineUsers getOnlineUsers() {
        return onlineUsers;
    }

    public void setOnlineUsers(OnlineUsers onlineUsers) {
        this.onlineUsers = onlineUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        onlineUsers.add(name);
        System.out.println(name+"is bound with a session");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        onlineUsers.remove(name);
        System.out.println(name+"is unbound with a session");
    }
}
