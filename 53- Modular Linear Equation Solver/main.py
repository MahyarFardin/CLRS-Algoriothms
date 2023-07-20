# ax = b (mod n)

def ExtendedEuclidean(a, b):
    if b == 0:
        return a, 1, 0
    
    d1, x1, y1 = ExtendedEuclidean(b, a % b)
    return (d1, y1, x1 - (a // b) * y1 )

def EquationSolver(a, b, n):
    d, xp, yp = ExtendedEuclidean(a, b)
    if b % d == 0:
        x0 = (xp * (d / b)) % n
        for i in range(d):
            print((x0 + (i * (n / d))) % n)
    else:
        print("No solution")
        
EquationSolver(14, 30, 100)
