class App {
    public static int maxSubarr(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum)  leftSum = sum;
        }

        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) rightSum = sum;
        }

        return Math.max(rightSum, Math.max(leftSum, rightSum + leftSum));
    }

    public static int findMaximum(int[] arr, int low, int high) {
        if (low > high)
            return 0;
        else if (low == high)
            return arr[low];
        else {
            int mid = (int) Math.floor((low + high) / 2);
            return Math.max(findMaximum(arr, low, mid - 1),
                    Math.max(findMaximum(arr, mid + 1, high), maxSubarr(arr, low, mid, high)));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        int res = findMaximum(arr, 0, arr.length - 1);
        System.out.println(res);
    }
}