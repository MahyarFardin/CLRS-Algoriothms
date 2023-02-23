import sys
from builtins import print


def Matrix_Multiply(A, B):
    # for example:
    #     |2 4|       |1 3 2|                 |2 4|   |1 3 2|   |38 14 32|
    # A = |5 6| , B = |9 2 7| ==> C = A * B = |5 6| * |9 2 7| = |59 27 52|
    #     |8 4|                               |8 4|             |44 32 44|
    # function return C -> [[38, 14, 32], [59, 27, 52], [44, 32, 44]]
    if len(A[0]) != len(B):
        print("incompatible dimensions")
    else:
        C = [[0] * len(B[0]) for i in range(len(A))]
        for i in range(len(A)):
            for j in range(len(B[0])):
                for k in range(len(A[0])):
                    C[i][j] += A[i][k] * B[k][j]
        return C


def Matrix_Chain_Order(p):
    n = len(p)
    m, s = [[0 for i in range(n)] for i in range(n)], [[0 for i in range(n)] for i in range(n)]
    for i in range(1, n):
        m[i][i] = 0
    for l in range(2, n):
        for i in range(1, n - l + 1):
            j = i + l - 1
            m[i][j] = sys.maxsize
            for k in range(i, j):
                q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]
                if q < m[i][j]:
                    m[i][j] = q
                    s[i][j] = k
    return m and s    


def Print_Optimal_Parens(s, i, j):
    # CLRS book example:
    # p = [30, 35, 15, 5, 10, 20, 25] , i = 1 , j = 6
    # output -> ((A_1(A_2A_3))((A_4A_5)A_6))
    if i == j:
        print(f"A_{i}", end='')
    else:
        print("(", end='')
        Print_Optimal_Parens(s, i, s[i][j])
        Print_Optimal_Parens(s, s[i][j] + 1, j)
        print(")", end='')


p = [30, 35, 15, 5, 10, 20, 25]
s = Matrix_Chain_Order(p)
Print_Optimal_Parens(s, 1, len(p) - 1)
