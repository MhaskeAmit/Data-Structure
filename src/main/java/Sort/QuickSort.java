package Sort;

public class QuickSort {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public  int pivot(int[] array,int pivotIndex,int endIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex+1;i<=endIndex;i++){
            if(array[i] < array[pivotIndex]){
                swapIndex++;
                swap(array,swapIndex,i);
            }
        }
        swap(array,pivotIndex,swapIndex);
        return swapIndex;
    }
    public void quickSortHelper(int[] array, int left, int right){

        if(left < right){
            int pivotIndex = pivot(array,left,right);
            quickSortHelper(array,left,pivotIndex-1);
            quickSortHelper(array,pivotIndex+1,right);
        }
    }


    public  void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }
}
