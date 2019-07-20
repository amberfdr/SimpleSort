package voltage.insertion.sort;

public class ShellSort {
    protected int[] insertSortd(int[] arr){
        int length = arr.length;
        int temp;
        //逐步缩小增量
        for(int gap = length/2;gap > 0;gap/=2){
            //对元素组使用直接插入排序法进行排序
            for(int i = gap;i < length;i++){
                temp = arr[i];
                int preIndex = i - gap;
                while(preIndex >= 0 && temp < arr[preIndex]){
                    //preIndex = gap 是要移动的位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                //preIndex + gap 是最终待排元素插入的位置
                arr[preIndex + gap] = temp;
            }

        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 7, 2, 4, 9, 6};
        int[] newArr = new ShellSort().insertSortd(arr);
        new TraversalArray(newArr).traversal();
    }
}
