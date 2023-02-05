package com.algorithms;


public final class App {
    private App() {
    }


    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static int partition(int[] a, int p, int r){
        int x = a[r];
        int i = p - 1;
        for (int j = p ; j < r-1 ; j++){
            if (a[j] <= x){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i+1, r);
        return i + 1;
    }


    public static int randomizedPartition(int[] a, int p, int r){
        int i = (int)(Math.random()*(r - p) + p);
        swap(a, i, r);
        return partition(a, p, r);
    }


    public static int randomizedSelect(int[] a, int p, int r, int i){
        if (p == r){
            return a[p];
        }
        int q = randomizedPartition(a, p, r);
        int k = q - p + 1;
        if (i == k){
            return a[q];
        }
        else if(i < k){
            return randomizedSelect(a, p, q-1, i);
        }
        else{
            return randomizedSelect(a, q+1, r, i-k);
        }
    }


    public static void main(String[] args) {
        int[] a = {5, 7, 8, 10, 25, 99, 126, 542, 542};
        int i = (int) Math.abs(Math.random()*(a.length - 1) + 1);
        System.out.println("i : "+ i);
        System.out.println(randomizedSelect(a,0, 8, i));
    }
}
