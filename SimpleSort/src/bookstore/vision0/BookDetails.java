package bookstore.vision0;

/**
 * Describe: 每本书的资料
 *
 * @Author fuderong
 * @Date 2019/11/29
 * @Version 1.0
 */
public class BookDetails implements Comparable{
    private String bookId = null;
    private String title = null;
    private String name = null;
    private float price = 0.0F;
    private int year = 0;
    private String description = null;
    private int saleAmount;

    public BookDetails(String bookId, String title, String name, float price, int year, String description, int saleAmount) {
        this.bookId = bookId;
        this.title = title;
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
        this.saleAmount = saleAmount;
    }

    public void setBookId(String bookId){
        this.bookId = bookId;
    }
    public String getBookId(){
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     * TODO 干啥
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        BookDetails n = (BookDetails) o;
        // TODO 看这个方法
        int lastCmp = title.compareTo(n.getTitle());
        return lastCmp;
    }
}
