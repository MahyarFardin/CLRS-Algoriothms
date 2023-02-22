package com.algorithms;


public final class App {
    private App() {
    }

    

    public static int cutRod(int p[], int n){
        int r[] = new int[n + 1];
        r[0] = 0;
        for (int j = 1 ; j <= n; j++){
            int q = Integer.MIN_VALUE;
            for (int i = 0 ; i < j; i++){
                q = Math.max(q, p[i] + r[j-i-1]);
            }
            r[j] = q;
        }
        return r[n];
    }


    public static void main(String[] args) {
        int arr[] = new int [10];
        
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 10);
        }
        System.out.println(cutRod(arr, arr.length));
    }
}
