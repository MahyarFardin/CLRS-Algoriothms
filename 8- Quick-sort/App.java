import java.util.Arrays;

class App {
    public static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    // this is the randomized part

    // public static int randomizedPartition(int [] arr, int l, int r) {

    //     int i =(int) Math.random() * ( r - l ) + l;
    //     swap(arr, r, i);
    //     return partition(arr, l, r);

    // }

    public static int partition(int [] arr, int l, int r) {
        int x = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                i++;    
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, r);
        
        return i+1;
    }

    public static void quickSort(int[] numbers, int l, int r) {
        if( l < r ){

            // this is the randomized part
            
            // int q = randomizedPartition(numbers, l, r);

            int q = partition(numbers, l, r);

            quickSort(numbers, l, q - 1);
            quickSort(numbers, q + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println("Input");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1 );

        System.out.println("Output");
        System.out.println(Arrays.toString(arr));

    }
}