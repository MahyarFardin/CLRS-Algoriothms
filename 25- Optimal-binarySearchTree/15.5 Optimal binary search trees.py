import sys
from decimal import *


def Optimal_BST(p, q, n):
    # CLRS Book example:
    # p = [0, 0.15, 0.10, 0.05, 0.10, 0.20]
    # q = [0.05, 0.10, 0.05, 0.05, 0.05, 0.10]
    # n = 5
    # e = [
    #      [0.05, 0.45, 0.9, 1.25, 1.75, 2.75],
    #      [0, 0.1, 0.4, 0.7, 1.2, 2.0], 
    #      [0, 0, 0.05, 0.25, 0.6, 1.3], 
    #      [0, 0, 0, 0.05, 0.3, 0.9], 
    #      [0, 0, 0, 0, 0.05, 0.5], 
    #      [0, 0, 0, 0, 0, 0.1]
    #      ]
    # w = [
    #     [0.05, 0.3, 0.45, 0.55, 0.7, 1.0],
    #     [0, 0.1, 0.25, 0.35, 0.5, 0.8],
    #     [0, 0, 0.05, 0.15, 0.3, 0.6],
    #     [0, 0, 0, 0.05, 0.2, 0.5], 
    #     [0, 0, 0, 0, 0.05, 0.35],
    #     [0, 0, 0, 0, 0, 0.1]
    #     ]
    # root = [
    #        [1, 1, 2, 2, 2],
    #        [0, 2, 2, 2, 4],
    #        [0, 0, 3, 4, 5],
    #        [0, 0, 0, 4, 5],
    #        [0, 0, 0, 0, 5]
    #        ]
    e, w = [[0 for i in range(n + 1)] for i in range(n + 1)], [[0 for i in range(n + 1)] for i in range(n + 1)]
    root = [[0 for i in range(n)] for i in range(n)]
    for i in range(n + 1):
        e[i][i] = q[i]
        w[i][i] = q[i]
    for l in range(1, n + 1):
        for i in range(1, n - l + 2):
            j = i + l - 1
            e[i - 1][j] = sys.maxsize
            w[i - 1][j] = float(Decimal(f"{w[i - 1][j - 1]}") + Decimal(f"{p[j]}") + Decimal(f"{q[j]}"))
            for r in range(i, j + 1):
                t = float(Decimal(f"{e[i - 1][r - 1]}") + Decimal(f"{e[r][j]}") + Decimal(f"{w[i - 1][j]}"))
                if t < e[i - 1][j]:
                    e[i - 1][j] = t
                    root[i - 1][j - 1] = r
    return e and root


p = [0, 0.15, 0.10, 0.05, 0.10, 0.20]
q = [0.05, 0.10, 0.05, 0.05, 0.05, 0.10]
n = len(p)
print(Optimal_BST(p, q, 5)) # output -> [[1, 1, 2, 2, 2], [0, 2, 2, 2, 4], [0, 0, 3, 4, 5], [0, 0, 0, 4, 5], [0, 0, 0, 0, 5]]
