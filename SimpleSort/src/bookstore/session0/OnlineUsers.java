package bookstore.session0;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe:在线用户的名单
 *
 * @Author fuderong
 * @Date 2019/12/6
 * @Version 1.0
 */
public class OnlineUsers {
    // 唯一onlineUsers实例
    private static final OnlineUsers onlineUsers = new OnlineUsers();
    /**
     * 存放在线用户名单
     */
    private List<String> users = new ArrayList<String>();

    /**
     * 添加一个用户
     * @param name
     */
    public void add(String name){
        users.add(name);
    }

    /**
     * 删除一个用户
     * @param name
     */
    public void remove(String name){
        users.remove(name);
    }

    /**
     * 返回一个用户列表
     * @return
     */
    public List getUser(){
        return users;
    }

    /**
     * 返回一个在线用户人数
     * @return
     */
    public int getCount(){
        return users.size();
    }

    /**
     * 返回一个OnlineUsers实例
     * @return
     */
    public static OnlineUsers getInstance(){
        return onlineUsers;
    }
}
