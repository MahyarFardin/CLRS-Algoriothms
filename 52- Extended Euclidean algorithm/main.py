# cd + ef = gcd(a, b)

def ExtendedEuclidean(a, b):
    if b == 0:
        return a, 1, 0
    
    d1, x1, y1 = ExtendedEuclidean(b, a % b)
    return (d1, y1, x1 - (a // b) * y1 )

print(ExtendedEuclidean(14, 30))