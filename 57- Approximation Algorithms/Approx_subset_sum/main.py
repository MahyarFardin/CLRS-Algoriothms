def merge_lists(L1, L2):
    return sorted(set(L1 + L2))

def Trim(L, e):
    L_prime = []
    last = L[0]
    L_prime.append(last)
    
    for i in range(1, len(L)):
        if L[i] > last * (1 + e):
            L_prime.append(L[i])
            last = L[i]
    
    return L_prime

def Approx_subset_sum(S, t, e):
    n = len(S)
    L = [[0]]
    
    for i in range(1, n+1):
        L.append(merge_lists(L[i-1], [x + S[i-1] for x in L[i-1]]))
        L[i] = Trim(L[i], e/(2*n))
        L[i] = [x for x in L[i] if x <= t]
    
    z_star = max(L[n])
    return z_star

#clrs example 
S = [104, 102 ,201, 101]
t = 308
e = 0.4

result = Approx_subset_sum(S, t, e)
print(result)