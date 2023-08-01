import numpy as np


def lu_decomposition(A):
    n = A.shape[0]
    l = np.zeros((n, n))
    u = np.zeros((n, n))
    for i in range(n):
        for j in range(n):
            l[i, i] = 1
            if j > i:
                l[i, j] = 0

    for i in range(n):
        for j in range(n):
            if j < i:
                u[i, j] = 0

    for k in range(n):
        u[k, k] = A[k, k]
        for i in range(k+1, n):
            l[i, k] = A[i, k] / u[k, k]
            u[k, i] = A[k, i]
        for i in range(k+1, n):
            for j in range(k+1, n):
                A[i, j] = A[i, j] - (l[i, k] * u[k, j])

    return l, u


def lu_solve(l, u, b):
    n = l.shape[0]
    y = np.zeros(n)
    x = np.zeros(n)

    for i in range(n):
        y[i] = b[i]
        for j in range(i):
            y[i] -= l[i, j] * y[j]
        y[i] /= l[i, i]

    for i in range(n-1, -1, -1):
        x[i] = y[i]
        for j in range(i+1, n):
            x[i] -= u[i, j] * x[j]
        x[i] /= u[i, i]

    return x


A = np.array([[3, 6, -9],
              [2, 5, -3],
              [-4, 1, 10]])

b = np.array([0, -4, 3])
l, u = lu_decomposition(A)
print("L = \n", l)
print("U = \n", u)
print("x = \n", lu_solve(l, u, b))

