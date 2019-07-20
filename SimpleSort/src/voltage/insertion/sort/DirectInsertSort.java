package voltage.insertion.sort;

import java.util.Arrays;

/**
 * 直接插入排序的代码实现
 */
public class DirectInsertSort {
    /**
     *
     * @param arr   in-place
     *
     */
    public int[] insertSortd(int[] arr) {
        //TODO 数组遍历方式的总结
        // Arrays.asList() 的用法
        int i, j;
        for (i = 1 ; i < arr.length; i++) {
            //temp为本次插入有序表中的元素
            int temp = arr[i];
            j = i - 1;
            while( j >= 0 && temp < arr[j]){
                //将大于插入元素的元素，后移，确定小于temp的下标j
                arr[j + 1] = arr[j];
                j--;
            }
            //为什么是j+1 ? 找到小于temp的下标j, j+1就是temp该插入的地方
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3, 1, 5, 7, 2, 4, 9, 6};
        int[] newArr = new DirectInsertSort().insertSortd(arr);
        new TraversalArray(newArr).traversal();
    }

}
