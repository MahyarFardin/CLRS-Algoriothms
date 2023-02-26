import sys


def Cut_Rod(p, n):
    if n == 0:
        return 0
    q = -sys.maxsize
    for i in range(n):
        q = max(q, p[i] + Cut_Rod(p, n - i - 1))
    return q


def Memoized_Cut_Rod(p, n):
    r = [i for i in range(n)]
    for i in range(n):
        r[i] = -sys.maxsize
    return Memoized_Cut_Rod_Aux(p, n, r)


def Memoized_Cut_Rod_Aux(p, n, r):
    if r[n - 1] >= 0:
        return r[n - 1]
    if n == 0:
        q = 0
    else:
        q = -sys.maxsize
        for i in range(n):
            q = max(q, p[i] + Memoized_Cut_Rod_Aux(p, n - i - 1, r))
    r[n - 1] = q
    return q   


def Bottom_Up_Cut_Rod(p, n):
    r = [0 for i in range(n + 1)]
    r[0] = 0
    for j in range(1, n + 1):
        q = -sys.maxsize
        for i in range(j):
            q = max(q, p[i] + r[j - i - 1])
        r[j] = q
    r[n] = q
    return r[n]


def Extended_Bottom_Up_Cut_Rod(p, n):
    r, s = [0 for i in range(n + 1)], [0 for i in range(n + 1)]
    for j in range(1, n + 1):
        q = -sys.maxsize
        for i in range(1, j + 1):
            if q < p[i - 1] + r[j - i]:
                q = p[i - 1] + r[j - i]
                s[j] = i
        r[j] = q
    return r and s


def Print_Cut_Rod_Solution(p, n):
    r, s = Extended_Bottom_Up_Cut_Rod(p, n), Extended_Bottom_Up_Cut_Rod(p, n)
    while n > 0:
        print(s[n], end=" ")
        n = n - s[n]


p = [1, 5, 8, 9, 10, 17, 17, 20, 24, 30]
print(Cut_Rod(p, 4))  # output -> 10
print(Memoized_Cut_Rod(p, 7))  # output -> 18
print(Bottom_Up_Cut_Rod(p, 9))  # output -> 25
Print_Cut_Rod_Solution(p, 9)  # -> 3 6
