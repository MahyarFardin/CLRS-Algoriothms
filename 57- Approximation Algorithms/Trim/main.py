def trim(L,e):
    L_prime = [L[0]]
    last = L[0]
    for i in range(1, len(L)):
        if L[i] > last * (1 + e):
            L_prime.append(L[i])
            last = L[i]
    return L_prime

#clrs example 
L = [10, 11, 12, 15, 20, 21, 22, 23, 24, 29] 
result = trim(L,  0.1)
print(result)