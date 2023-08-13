def modular_exponention(a, b, n):
    c = 0
    d = 0
    b = str(bin(b))[2:] 
    for i in b:
        c *= 2
        d = (d * d) % n
        if i == 0:
            c += 1 
            d = (d * a) % n
    print(d)

modular_exponention(1, 6, 3)
        