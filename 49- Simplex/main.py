import numpy as np


def pivot(N, B, A, b, c, v, l, e):
    m, n = A.shape
    A_bar = np.copy(A)
    b_bar = np.copy(b)
    c_bar = np.copy(c)
    b_bar[l] = b[l] / A[l][e]
    for j in N:
        if j != e:
            A_bar[l][j] = A[l][j] / A[l][e]
    A_bar[l][e] = 1 / A[l][e]

    for i in B:
        if i != l:
            b_bar[i] = b[i] - A[i][e] * b_bar[l]
            for j in N:
                if j != e:
                    A_bar[i][j] = A[i][j] - A[i][e] * A_bar[l][j]
            A_bar[i][e] = -A[i][e] * A_bar[l][e]

    v_bar = v + c[e] * b_bar[l]
    for j in N:
        if j != e:
            c_bar[j] = c[j] - c[e] * A_bar[l][j]
    c_bar[e] = -c[e] * A_bar[l][e]

    N_bar = np.setdiff1d(N, [e]) + [l]
    B_bar = np.setdiff1d(B, [l]) + [e]

    return N_bar, B_bar, A_bar, b_bar, c_bar, v_bar


def initialize_simplex(A, b, c):
    m, n = A.shape
    k = np.argmin(b)
    if b[k] >= 0:
        return np.arange(n), np.arange(n + m), A, b, c, 0

    L_aux = np.hstack((np.zeros((m, 1)), A, np.eye(m)))
    c_aux = np.concatenate(([0], np.zeros(n), np.ones(m)))

    N, B, A, b, c, v = pivot(np.arange(n + m + 1), np.arange(n + m + 1), L_aux, b, c_aux, 0, n + k, 0)

    while any(c[j] < 0 for j in N):
        e = np.argmin(c[N])
        delta = np.inf * np.ones(m)
        for i in B:
            if A[i][e] > 0:
                delta[i - n] = b[i] / A[i][e]
        l = np.argmin(delta)
        if delta[l] == np.inf:
            return "infeasible"
        else:
            N, B, A, b, c, v = pivot(N, B, A, b, c, v, l, e)

    for j in range(len(B)):
        if B[j] == n:
            l = j
            break

    for i in range(len(B)):
        if i != l:
            b[i] = b[i] - A[i][n] * b[l]
            A[i][n] = 0

    c = c[1:] - c[0] * A[l][1:]
    return (N[1:], B[1:], A[:, 1:], b, c, v)


def simplex(A, b, c):
    m, n = A.shape
    N, B, A, b, c, v = initialize_simplex(A, b, c)

    while any(c[j] > 0 for j in N):
        e = np.argmax(c[N])
        delta = np.inf * np.ones(m)
        for i in B:
            if A[i][e] > 0:
                delta[i - n] = b[i] / A[i][e]
        l = np.argmin(delta)
        if delta[l] == np.inf:
            return "unbounded"
        else:
            N, B, A, b, c, v = pivot(N, B, A, b, c, v, l, e)

    x_bar = np.zeros(n + m)
    for i in range(len(B)):
        if B[i] < n:
            x_bar[B[i]] = b[i]

    return x_bar[:n]


A = np.array([[2, 1, 1],
              [4, 2, 3],
              [2, 5, 5]])
b = np.array([4, 12, 15])
c = np.array([-3, -2, -4])

result = simplex(A, b, c)
print("Optimal solution:", result)