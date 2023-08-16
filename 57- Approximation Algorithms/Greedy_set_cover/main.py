def greedy_set_cover(X, F):
    U = set(X)
    C = []
    while U:
        max_set = None
        max_cover = set()
        for i in F:
            S = U.intersection(i)
            if len(S) > len(max_cover):
                max_set = i
                max_cover = S
        if max_set is None:
            break
        C.append(max_set)
        U -= max_cover
    return C


X = set(range(1, 11))
F = [{1, 2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {1, 2, 3}, {4, 5, 6}, {7, 8, 9}]
C = greedy_set_cover(X, F)
print(C)
