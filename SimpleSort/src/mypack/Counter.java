package mypack;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/15
 * @Version 1.0
 */
public class Counter {
    /**
     * 计数值
     */
    private int count;
    public Counter( ) {
        this(0);
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void add(int step){
       count+=step;
    }
}
