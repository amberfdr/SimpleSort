package bookstore.session0;

import java.util.HashMap;

/**
 * Describe: 购物车
 *
 * @Author fuderong
 * @Date 2019/11/29
 * @Version 1.0
 */
public class ShoppingCart {
    /**
     * 将条目放到购物车中
     */
    HashMap<String,Integer> items = new HashMap<String,Integer>();
    /**
     * 购物车中的总数量
     */
    int numberOfItems = 0;

    public synchronized void add(String itemName){
        if(items.containsKey(itemName)){
            Integer itemCount = (Integer)items.get(itemName);
            items.put(itemName,itemCount+1);
        }else{
            items.put(itemName,1);
        }
        numberOfItems++;
    }

    public synchronized HashMap<String, Integer> getItems() {
        return items;
    }

    public synchronized int getNumberOfItems() {
        return numberOfItems;
    }

}
