import java.util.*;

class App {
    public static void maxHeapify(int [] arr, int i){
        int largest=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left < arr.length && arr[left] > arr[i])    largest = left;
        else largest=i;

        if(right < arr.length && arr[right] > arr[largest])    largest = right;

        if(largest != i){
            
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, largest);
        }
    }

    public static void buildMaxHeapify(int [] arr) {
        for (int i =(int) Math.floor((arr.length/2)-1) ; i >= 0; i--) {
            maxHeapify(arr, i);
        }        
    }
public static void main(String[] args) {
        int [] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random()*10);
        

        System.out.println("Input array:");
        System.out.println(Arrays.toString(arr));

        buildMaxHeapify(arr);

        System.out.println("Maxheap:");
        System.out.println(Arrays.toString(arr));       
    }
}