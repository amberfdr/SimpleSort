package voltage.insertion.sort;

/**
 * 遍历数组的方式总结
 */
public class TraversalArray {
    private int[] arr;
    public  void traversal(){
        for(int ele : arr){
            System.out.println(ele);
        }
    }
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public TraversalArray(int[] arr) {
        this.arr = arr;
    }
}
