package bookstore.session0;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Describe: 购物
 *
 * @Author fuderong
 * @Date 2019/12/4
 * @Version 1.0
 */
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] itemNames = {"糖果","收音机","练习簿"};
        // 获取HttpSession对象
        HttpSession session = req.getSession(true);
        ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
        // 如果会话范围内没有ShoppingCart对象就创建它，并存入会话范围内
        if(cart == null){
            cart = new ShoppingCart();
            session.setAttribute("cart",cart);
        }
        resp.setContentType("text/html;charset=GB2312");
        PrintWriter out = resp.getWriter();

        // 读取表单数据
        String[] itemsSelected;
        // 商品索引
        String itemIndex;
        // 商品名称
        String itemName;
        // 读取复选框的数据
        itemsSelected = req.getParameterValues("item");
        if(itemsSelected != null){
            for(int i = 0;i < itemsSelected.length;i++){
                itemIndex = itemsSelected[i];
                itemName = itemNames[Integer.parseInt(itemIndex)];
                cart.add(itemName);
            }
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>购物车的内容</title></head><body>");
        out.println("Session ID:"+session.getId()+"<br>");
        out.println("<center><h1>你的购物车有："+cart.getNumberOfItems()+"个商品</h1></center>");
        HashMap<String, Integer> items = cart.getItems();
        Iterator<Map.Entry<String, Integer>> iterator = items.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            out.println(entry.getKey()+":"+entry.getValue());
        }
        out.println("<a href='shopping.htm'>继续购物</a>");
        out.println("</body><html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
