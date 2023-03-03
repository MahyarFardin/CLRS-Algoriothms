def activity_selector(s,f):
    n = len(s)
    k = 0
    A = []
    A.append(k)
    for m in range(1, n):
        if s[m] >= f[k]:
            A.append(m)
            k = m
    return A


s = [1, 3, 0, 5, 6, 8, 8, 2, 12]
f = [0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16]

A = activity_selector(s, f)
print(A)