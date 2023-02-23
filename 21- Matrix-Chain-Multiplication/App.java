package com.algorithms;


public final class App {
    private App() {
    }


    public static int matrixChainOrder(int p[], int[][] s) {
        int n = p.length;
        int[][] m = new int[n][n];
        int j, q;

        for (int i = 1 ; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                j = i + l - 1;
                if (j == n){
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[1][n - 1];
    }


    public static void printOptimalParenthesis(int[][] s, int i, int j){
        if (i == j) { 
            System.out.print("A"+ i);
            return;
        }
        System.out.print("(");
        printOptimalParenthesis(s, i, s[i][j]);
        printOptimalParenthesis(s, s[i][j] +1, j);
        System.out.print(")");
        
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 8, 10, 9};
        int[][]s = new int[arr.length][arr.length];
        System.out.println("The Minimum number of multiplications : "+ matrixChainOrder(arr, s));
        System.out.print("The optimal parenthesis would be : ");
        printOptimalParenthesis(s, 1, arr.length - 1);
    }
}
