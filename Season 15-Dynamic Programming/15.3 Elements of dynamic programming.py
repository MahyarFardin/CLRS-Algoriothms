import sys


def Recursive_Matrix_Chain(p, i, j):
    if i == j:
        return 0
    _min = sys.maxsize
    for k in range(i, j):
        q = (Recursive_Matrix_Chain(p, i, k)
        + Recursive_Matrix_Chain(p, k + 1, j)
        + p[i - 1] * p[k] * p[j])
        if q < _min:
            _min = q
    return _min


def Memoized_Matrix_Chain(p):
    n = len(p) - 1
    m = [[0 for i in range(n + 1)] for i in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(i, n + 1):
            m[i][j] = sys.maxsize
    return Lookup_Chain(m, p, 1, n)


def Lookup_Chain(m, p, i, j):
    if m[i][j] < sys.maxsize:
        return m[i][j]
    if i == j:
        m[i][j] = 0
    else:
        for k in range(i, j):
            q = (Lookup_Chain(m, p, i, k)
            + Lookup_Chain(m, p, k + 1, j)
            + p[i - 1] * p[k] * p[j])
            if q < m[i][j]:
                m[i][j] = q
    return m[i][j]


print(Recursive_Matrix_Chain([30, 35, 15, 5, 10, 20, 25], 1, 6)) # output -> 15125
print(Memoized_Matrix_Chain([1, 2, 3, 4])) # output -> 18
