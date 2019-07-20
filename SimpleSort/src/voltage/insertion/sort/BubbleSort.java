package voltage.insertion.sort;

public class BubbleSort {
    protected int[] insertSortd(int[] arr) {
        int max;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //arr.length - 1 - i
                // 减1是因为后面有用到 j+1 ,这样会用到数组越界，j只需要到数组的倒数第二个就可以了
                // arr这里的i是已经排好序的元素个数
                if(arr[j] > arr[j+1]){
                    max = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = max;
                }

            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3, 1, 5, 7, 2, 4, 9, 6};
        int[] newArr = new BubbleSort().insertSortd(arr);
        new TraversalArray(newArr).traversal();
    }
}
