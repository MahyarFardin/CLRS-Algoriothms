import java.util.*;

class App {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void maxHeapify(int[] arr, int i, int size) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < size && arr[left] > arr[i])
            largest = left;
        else
            largest = i;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            
            swap(arr, i, largest);

            maxHeapify(arr, largest, size);
        }
    }

    public static void buildMaxHeapify(int[] arr) {
        for (int i = (int) Math.floor(arr.length / 2); i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    public static void heapSort(int [] arr){
        buildMaxHeapify(arr);

        for (int i = arr.length-1 ; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10);

        System.out.println("Input array:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Maxheap:");
        System.out.println(Arrays.toString(arr));
    }
}