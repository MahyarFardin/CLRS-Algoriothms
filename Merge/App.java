class App {
    public static void merge(int[] numbers, int l, int m, int r) {
        {
            int leftSize = m - l + 1;
            int rightSize = r - m;

            int[] left = new int[leftSize];
            int[] right = new int[rightSize];

            for (int i = 0; i < leftSize; ++i) {
                left[i] = numbers[i + l];
            }

            for (int i = 0; i < rightSize; ++i) {
                right[i] = numbers[m + 1 + i];
            }

            int i = 0, j = 0, k = l;

            while (i < leftSize && j < rightSize) {
                if (left[i] <= right[j]) {
                    numbers[k] = left[i];
                    i++;
                } else {
                    numbers[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < leftSize) {
                numbers[k] = left[i];
                i++;
                k++;
            }

            while (j < rightSize) {
                numbers[k] = right[j];
                j++;
                k++;
            }
        }

    }

    public static void mergeSort(int[] numbers, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(numbers, l, m);
            mergeSort(numbers, m + 1, r);

            merge(numbers, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] a = { 5, 4, 6, 8, 2, 1 };

        mergeSort(a, 0, a.length-1);

        for (int i : a) {
            System.out.println(i);
        }
    }
}