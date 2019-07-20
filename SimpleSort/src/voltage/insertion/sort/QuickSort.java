package voltage.insertion.sort;

public class QuickSort {
    /**
     * 这是一个递归
     * 退出条件 ： low >= high
     * @param arr
     * @param low
     * @param high
     * @return
     */
    protected int[] insertSortd(int[] arr,int low,int high) {

        if(low < high){
            //基准数据的下标
            int pivotIndex = findIndex(arr,low,high);
            //以基准数据的位置向前和向后  继续进行 快速排序
            insertSortd(arr,low,pivotIndex-1);
            insertSortd(arr,pivotIndex+1,high);
        }
        return arr;
    }

    /**
     * 寻找基准数据的下标
     * 1.当队尾元素 >= 基准数据，high指针向左移动
     *  当队尾元素 < 基准数据，将其赋值给队首元素
     * 2.当对首元素 <= 基准数据，low指针向右移动
     *  当对首元素 > 基准数据，将其赋值给队尾元素
     * 3.将基准数据赋值到它应该的位置
     * @param arr
     * @param low
     * @param high
     * @return
     */
    protected int findIndex(int[] arr,int low,int high){
        int pivot = arr[low];//基准数据
        while (low < high){

            while (low < high && arr[high] >= pivot){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,3, 1, 5, 7, 2, 4, 9, 6};
        int[] newArr = new QuickSort().insertSortd(arr,0,arr.length-1);
        new TraversalArray(newArr).traversal();
    }
}
