package voltage.insertion.sort;

public class SelectionSort {
    protected int[] insertSortd(int[] arr){
        int min,flag;
        for(int i = 0; i < arr.length; i++){
            min = arr[i];
            flag = i;
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    flag = j;
                }
            }
            arr[flag] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3, 1, 5, 7, 2, 4, 9, 6};
        int[] newArr = new SelectionSort().insertSortd(arr);
        new TraversalArray(newArr).traversal();
    }
}
