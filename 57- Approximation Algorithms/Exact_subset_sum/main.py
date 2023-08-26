def exact_subset_sum(S, t):
    n = len(S)
    L = [[False] * (t+1) for _ in range(n+1)]
    L[0][0] = True

    for i in range(1, n+1):
        for j in range(t+1):
            if j < S[i-1]:
                L[i][j] = L[i-1][j]
            else:
                L[i][j] = L[i-1][j] or L[i-1][j-S[i-1]]

    largest_element = None
    for j in range(t, -1, -1):
        if L[n][j]:
            largest_element = j
            break

    return largest_element


# clrs example
S = [1, 4, 5]
t = 9   # t = 10 , t = 11 , t = 5
largest_element = exact_subset_sum(S, t)
print("The largest subset sum that is equal to", t, "is", largest_element)
