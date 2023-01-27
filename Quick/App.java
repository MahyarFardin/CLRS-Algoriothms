class App {
    public static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void quickSort(int[] numbers, int l, int r) {
        int rp = r;
        int lp = l;
        int pivote = r;

        if (rp < lp)
            return;

        while (rp > lp) {

            while (numbers[lp] <= numbers[pivote] && lp < rp)
                lp++;

            while (numbers[rp] >= numbers[pivote] && lp < rp)
                rp--;

            swap(numbers, rp, lp);
        }

        swap(numbers, pivote, rp);

        quickSort(numbers, l, rp - 1);
        quickSort(numbers, rp + 1, r);
    }

    public static void main(String[] args) {
        int[] a = new int[1000000];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000000);
        }

        quickSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}