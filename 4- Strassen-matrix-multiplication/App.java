public class App {
    public static int[][] sub(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] - b[i][j];

        return c;
    }

    public static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] + b[i][j];

        return c;
    }

    public static int[][] strassen(int[][] a, int[][] b) {
        int n = a.length;

        int[][] c = new int[n][n];
        int[][] c11 = new int[n / 2][n / 2];
        int[][] c12 = new int[n / 2][n / 2];
        int[][] c21 = new int[n / 2][n / 2];
        int[][] c22 = new int[n / 2][n / 2];

        if (n == 1)
            c[0][0] = a[0][0] * b[0][0];
        else {
            int[][] a11 = new int[n / 2][n / 2];
            int[][] a12 = new int[n / 2][n / 2];
            int[][] a21 = new int[n / 2][n / 2];
            int[][] a22 = new int[n / 2][n / 2];

            int[][] b11 = new int[n / 2][n / 2];
            int[][] b12 = new int[n / 2][n / 2];
            int[][] b21 = new int[n / 2][n / 2];
            int[][] b22 = new int[n / 2][n / 2];

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    a11[i][j] = a[i][j];
                    a12[i][j] = a[i][j + n / 2];
                    a21[i][j] = a[i + n / 2][j];
                    a22[i][j] = a[i + n / 2][j + n / 2];

                    b11[i][j] = b[i][j];
                    b12[i][j] = b[i][j + n / 2];
                    b21[i][j] = b[i + n / 2][j];
                    b22[i][j] = b[i + n / 2][j + n / 2];
                }
            }

            int[][] s1 = sub(b12, b22);
            int[][] s2 = add(a11, a12);
            int[][] s3 = add(a12, a22);
            int[][] s4 = sub(b21, b11);
            int[][] s5 = add(a11, a22);
            int[][] s6 = add(b11, b22);
            int[][] s7 = sub(a12, a22);
            int[][] s8 = add(b21, b22);
            int[][] s9 = sub(a11, a21);
            int[][] s10 = add(b11, b12);

            int[][] p1 = strassen(a11, s1);
            int[][] p2 = strassen(s2, b22);
            int[][] p3 = strassen(s3, b11);
            int[][] p4 = strassen(a22, s4);
            int[][] p5 = strassen(s5, s6);
            int[][] p6 = strassen(s7, s8);
            int[][] p7 = strassen(s9, s10);

            c11 = add(sub(add(p5, p4), p2), p6);
            c12 = add(p1, p2);
            c21 = add(p3, p4);
            c22 = sub(sub(add(p5, p1), p3), p7);

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    c[i][j] = c11[i][j];
                }
            }

            for (int i = 0; i < n / 2; i++) {
                for (int j = n / 2; j < n; j++) {
                    c[i][j] = c12[i][j - n / 2];
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    c[i][j] = c21[i - n / 2][j];
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = n / 2; j < n; j++) {
                    c[i][j] = c22[i - n / 2][j - n / 2];
                }
            }

        }

        return c;
    }

    public static void main(String[] args) {
        int[][] a = new int[4][4];
        int[][] b = new int[4][4];
        int[][] c = new int[4][4];

        // we assume that matrices are valid for multiplication
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = (int) (Math.random() * 10);
                b[i][j] = (int) (Math.random() * 10);
            }
        }

        c = strassen(a, b);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==========================");

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==========================");

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }

}