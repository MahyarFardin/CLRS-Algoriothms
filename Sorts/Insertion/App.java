public class App {
    public static void main(String[] args) {
        int[] a = { 5, 4, 6, 8, 2, 1 };

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int index=i;

            while (j > -1 && a[index] < a[j]) {
                int temp = a[index];
                a[index] = a[j];
                a[j] = temp;
                index=j;
                j--;
            }
        }

        for (int i : a) {
            System.out.println(i);
        }
    }
}

