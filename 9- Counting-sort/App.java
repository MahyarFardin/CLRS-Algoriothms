import java.util.Arrays;

class App{
    public static void countingSort(int [] arr, int [] b){
        // numbers are from 0 to 9
        int [] c = new int[10];

        for (int i : arr) {
            c[i]++;
        }

        for (int i = 1; i < c.length; i++) {
            c[i] += c[i-1];
        }

        for (int i = arr.length-1 ; i >= 0 ; i--) {
            b[c[arr[i]]-1] = arr[i];
            c[arr[i]]--;
        }

    }
    public static void main(String[] args) {

        int [] arr = new int[10];
        int [] b = new int[10];     // sorted array

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println("Input");
        System.out.println(Arrays.toString(arr));

        countingSort(arr, b);

        System.out.println("Output");
        System.out.println(Arrays.toString(b));

    }
}