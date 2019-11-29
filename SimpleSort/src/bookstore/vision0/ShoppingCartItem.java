package bookstore.vision0;

/**
 * Describe:购物车中的条目
 *
 * @Author fuderong
 * @Date 2019/11/29
 * @Version 1.0
 */
public class ShoppingCartItem {
    /**
     * item 代表用户买的书
     */
    Object item;
    /**
     * 表示买的数量
     */
    int quantity;

    public ShoppingCartItem(Object item) {
        this.item = item;
        this.quantity = 1;
    }
    public void incrementQuantity(){
        quantity++;
    }
    public void decrementQuantity(){
        quantity--;
    }
    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
