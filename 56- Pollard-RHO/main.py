import numpy as np

def pollard(n):
    i = 1
    x = np.random.uniform(1, n-1)
    y = x
    k = 2
    while True:
        i += 1
        x = (x ** 2 - 1) % n
        d = np.gcd(int(y - x), int(n))
        if d-1 and d != n:
            print(d)
        if i == k:
            y = x
            k *= 2

pollard(54)
            