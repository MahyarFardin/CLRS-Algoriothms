import java.util.Arrays;

class App {
    public static void insertionSort(float[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            float key = a[i];

            while (j > -1 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

    }

    public static void bucketSort(float[] arr) {
        // numbers are from 0 to 9
        // as assumption we have uniform distribution but because we could not make it in java
        // we choose a random number like 4 for it

        float[][] c = new float[10][4];

        for (float f : arr) {
            int i = 0;

            while (i < 4) {
                if (c[(int) Math.floor(f * 10)][i] == 0) {
                    c[(int) Math.floor(f * 10)][i] = f;
                    break;
                }
                i++;
            }
        }

        for (float[] temp : c) {
            insertionSort(temp);
        }

        int k = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j] != 0) {
                    arr[k] = c[i][j];
                    k++;
                }
            }
        }

    }

    public static void main(String[] args) {

        float[] arr = new float[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (Math.floor(Math.random() * 100)) / 100;
        }

        System.out.println("Input");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("Output");
        System.out.println(Arrays.toString(arr));

    }
}