import numpy as np


def lup_decomposition(A):

    n = A.shape[0]
    pi = np.arange(n)

    for k in range(n):
        p = 0
        for i in range(k, n):
            if np.abs(A[i, k]) > p:
                p = np.abs(A[i, k])
                k_prime = i
        if p == 0:
            raise ValueError("Singular Matrix")
        pi[k], pi[k_prime] = pi[k_prime], pi[k]
        for i in range(n):
            A[k, i], A[k_prime, i] = A[k_prime, i], A[k, i]
        for i in range(k+1, n):
            A[i, k] /= A[k, k]
            for j in range(k+1, n):
                A[i, j] -= (A[i, k] * A[k, j])

    P = np.eye(n)[pi, :]
    L = np.tril(A, k=-1) + np.eye(n)
    U = np.triu(A)

    return pi, P, L, U


def solve_lup(l, u, pi, b):

    n = l.shape[0]
    x = np.zeros(n)
    y = np.zeros(n)
    for i in range(n):
        #index = pi[i]
        y[i] = b[pi[i]] - sum(l[i, j] * y[j] for j in range(i))
    for i in range(n-1, -1, -1):
        x[i] = (y[i] - sum(u[i, j] * x[j] for j in range(i + 1, n))) / u[i, i]
    return x


A = np.array([[1.0, 5.0, 4.0],
              [2.0, 0, 3.0],
              [5.0, 8.0, 2.0]])


b = np.array([12.0, 9.0, 5.0])
pi, p, l, u = lup_decomposition(A)
x = solve_lup(l, u, pi, b)
print("x = \n", x)






