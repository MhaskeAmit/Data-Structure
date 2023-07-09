package Sort;

public class SelectionSort {

    public void selectionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int minVal = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    minVal = j;
                }
            }
            if(minVal!=i){
                int temp = arr[i];
                arr[i] = arr[minVal];
                arr[minVal] = temp;
            }
        }
    }

}
