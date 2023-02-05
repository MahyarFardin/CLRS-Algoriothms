package com.algorithms;


public final class App {
    private App() {
    }

    public static int[][] sub(int[][] A, int[][] B){
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < A.length; i++){
            for (int j = 0 ; j < A.length; j++){
                result[i][j] = A[i][j] - B[i][j];
            }
        }

        return result;
    }

    public static int[][] add(int[][] A, int[][] B){
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0 ; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }


    public static void devide(int[][] A, int[][]a, int iB, int jB){

        for (int i1 = 0, i2 = iB; i1 < a.length; i1++, i2++){
            for (int j1 = 0, j2 = jB; j1 < a.length; j1++, j2++){
                a[i1][j1] = A[i2][j2];
            }
        }
    }

    public static void combine(int[][] a, int[][] A, int iB, int jB){
        for (int i1 = 0, i2 = iB; i1 < a.length; i1++, i2++){
            for (int j1 = 0, j2 = jB; j1 < a.length; j1++, j2++){
                A[i2][j2] = a[i1][j1];
            }
        }
    }

    public static int[][] multiply(int[][] A, int[][] B){
        int n = A.length;

        int[][] result = new int[n][n];
        if (n == 1){
            result[0][0] = A[0][0] * B[0][0];
        }
        else{
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];

            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            devide(A, A11, 0, 0);
            devide(A, A12, 0, n / 2);
            devide(A, A21, n / 2, 0);
            devide(A, A22, n / 2, n / 2);
 
            devide(B, B11, 0, 0);
            devide(B, B12, 0, n / 2);
            devide(B, B21, n / 2, 0);
            devide(B, B22, n / 2, n / 2);

            int[][] M1 = multiply(add(A11, A22), add(B11, B22));
            int[][] M2 = multiply(add(A21, A22), B11);
            int[][] M3 = multiply(A11, sub(B12, B22));
            int[][] M4 = multiply(A22, sub(B21, B11));  
            int[][] M5 = multiply(add(A11, A12), B22);
            int[][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int[][] M7 = multiply(sub(A12, A22), add(B21, B22));
            
            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = add(sub(add(M1, M3), M2), M6);

            combine(C11, result, 0, 0);
            combine(C12, result, 0, n / 2);
            combine(C21, result, n / 2, 0);
            combine(C22, result, n / 2, n / 2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[4][4];
        int[][] B = new int[4][4];
        int[][] C = new int[4][4];

        for (int i = 0; i < A.length; i++){
            for ( int j = 0; j < A[0].length; j++){
                A[i][j] = (int)(Math.random()*10);
                B[i][j] = (int)(Math.random()*10);
            }
        }


        C = multiply(A, B);

        for (int i = 0; i < A.length; i++){
            for ( int j = 0; j < A[0].length; j++){
                System.out.print(A[i][j]+ "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");

        for (int i = 0; i < A.length; i++){
            for ( int j = 0; j < A.length; j++){
                System.out.print(B[i][j]+ "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
        
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < C.length; j++){
                 System.out.print(C[i][j] +"  ");
            }
            System.out.println();
        }
    }
}
