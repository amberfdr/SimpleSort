package bookstore.vision0;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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
    HashMap items = null;
    /**
     * 购物车中的总数量
     */
    int numberOfItems = 0;

    public ShoppingCart() {
        items = new HashMap();
    }

    /**
     * 添加书
     * @param bookId
     * @param book
     */
    public synchronized void add(String bookId,BookDetails book){
        if(items.containsKey(bookId)){
            ShoppingCartItem shoppingCartItem = (ShoppingCartItem)items.get(bookId);
            shoppingCartItem.incrementQuantity();
        }else{
            ShoppingCartItem newShoppingCartItem = new ShoppingCartItem(book);
            items.put(bookId,newShoppingCartItem);

        }
        numberOfItems++;
    }

    /**
     * 删除书
     * @param bookId
     */
    public synchronized void remove(String bookId){
        if(items.containsKey(bookId)){
            ShoppingCartItem shoppingCartItem = (ShoppingCartItem)items.get(bookId);
            shoppingCartItem.decrementQuantity();
            if(shoppingCartItem.getQuantity() <= 0){
                items.remove(bookId);
            }
        }
        numberOfItems--;
    }

    /**
     * TODO synchronized ?
     * TODO Collection ?
     * TODO HashMap的特性 ？
     * @return 获取所有书的条目
     */
    public synchronized Collection getItems(){
        return items.values();
    }

    /**
     * TODO finalize ?
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        items.clear();;
    }

    /**
     * 返回所有书的数量总和
     * @return
     */
    public synchronized int getNumberOfItems(){
        return numberOfItems;
    }

    /**
     * 计算所有书的总金额
     * @return
     */
    public synchronized double getTotal(){
        double amount = 0.0;
        for(Iterator i = getItems().iterator(); i.hasNext();){
            ShoppingCartItem item = (ShoppingCartItem)i.next();
            BookDetails bookDetails = (BookDetails)item.getItem();
            amount += item.getQuantity() * bookDetails.getPrice();
        }
        return roundOff(amount);
    }

    /**
     * 将金额四舍五入
     * TODO Math.round(x*100)?
     * @param x
     * @return
     */
    public double roundOff(double x){
        long round = Math.round(x * 100);
        return round/100;
    }

    /**
     * 清空购物车
     */
    public synchronized void clear(){
        items.clear();
        numberOfItems = 0;
    }

}
