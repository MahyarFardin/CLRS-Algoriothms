import java.util.Arrays;

class App {

    public static int[] trim(int[] arr, int[] a, int i){
        
        int digitPlace = (int) Math.pow(10,i);
        for (int j = 0; j < arr.length; j++) {
            a[j] = (int) Math.floor((arr[j] / digitPlace) % 10); 
        }

        return a;
    }

    public static int[] radixSort(int [] arr) {
        // numbers have 3 digits at most
        for (int i = 0; i < 3; i++) {
            
            int[] b = new int[10]; // sorted array
            int[] a = new int[arr.length]; // trimmed digits

            a = trim(arr, a, i);
            countingSort(arr, a, b);            
            arr=b;
        }
        return arr;
    }

    public static void countingSort(int[] arr, int[] a, int[] b) {
        // numbers are from 0 to 9
        int[] c = new int[10];

        for (int i : a) {
            c[i]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = arr[i];
            c[a[i]]--;
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        System.out.println("Input");
        System.out.println(Arrays.toString(arr));

        arr=radixSort(arr);

        System.out.println("Output");
        System.out.println(Arrays.toString(arr));

    }
}