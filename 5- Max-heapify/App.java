import java.util.*;

class App {
    public static void maxHeapify(int [] arr, int i){
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left <= arr.length && arr[left] > arr[i])    largest = left;
        else largest=i;

        if(right <= arr.length && arr[right] > arr[largest])    largest = right;

        if(largest != i){
            
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest);
        }
    }

public static void main(String[] args) {
        int [] arr = new int[16];
        int idx=0;

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random()*10);
        

        System.out.println("Input array:");
        System.out.println(Arrays.toString(arr));

        maxHeapify(arr, idx);

        System.out.println("applied maxheapify to: "+idx+"th element");
        System.out.println(Arrays.toString(arr));       
    }
}