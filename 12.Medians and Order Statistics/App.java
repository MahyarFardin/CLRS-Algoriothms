package com.algorithms;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        int[] array = {4,1,5,7,2,4,9,11,17,64,25,33,54};
        int k = 5;
        System.out.println("The first order statistics : "     + min(array));
        System.out.println("The "+ k+ "th order statistics : " + kthorder(array, k));
        System.out.println("The nth order statistics   : "     + max(array));
        System.out.println("The median : "+ median(array));
        System.out.println();
    }

    public static int min(int[] array){
        int min = array[0];
        for(int i = 1; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int[] array){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static int kthorder(int[] array, int k){
        sort(array);
        return array[k];
    }

    public static void sort(int[] array){
        int tmp;
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static int median(int[] array){
        sort(array);
        if(array.length % 2 != 0){
            return array[array.length/2]; 
        }
        return (array[(array.length/2)-1] + array[(array.length/2)]) / 2;
    }
}
