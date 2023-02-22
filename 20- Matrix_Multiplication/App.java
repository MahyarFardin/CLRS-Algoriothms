package com.algorithms;


public final class App {
    private App() {
    }

    
    public static void printMatrix(int[][] A){
        for ( int i = 0; i < A.length ; i++){
            for ( int j = 0 ; j < A[0].length; j++){
                System.out.print(A[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B){

        if (A[0].length != B.length){
            System.out.println(" error : incompatible dimensions . Can not be multiplied \n");
            return null;
        }

        int[][] C = new int[A.length][B[0].length];
        
        for (int i = 0 ; i < A.length; i++){
            for (int j = 0 ; j < B[0].length; j++){
                C[i][j] = 0;
                for (int k = 0 ; k < A[0].length ; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] A = new int[4][4];
        int[][] B = new int[4][4];

        for (int i = 0 ; i < A.length ; i++){
            for ( int j = 0; j < A[0].length ; j++){
                A[i][j] = (int)(Math.random() * 5);
            }
        }

        for (int i = 0 ; i < B.length ; i++){
            for ( int j = 0; j < B[0].length ; j++){
                B[i][j] = (int)(Math.random() * 5);
            }
        }

        printMatrix(A);
        System.out.println("=====================================================");
        printMatrix(B);
        System.out.println("=====================================================");
        printMatrix(multiplyMatrices(A, B));
    }
}
