public class App {
    public static void main(String[] args) {
        int[] a = { 5, 4, 6, 8, 2, 1 };

        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int key=a[i];

            while (j >-1 && key < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }

        for (int i : a) {
            System.out.println(i);
        }
    }
}

