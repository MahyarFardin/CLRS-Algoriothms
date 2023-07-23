def transitive_closure(T):
    assert (len(row) == len(T) for row in T)
    n = len(T)
    for k in range(n):
        for i in range(n):
            for j in range(n):
                T[i][j] = T[i][j] or (T[i][k] and T[k][j])
        # for row in T :
        #     print(row)       #show steps
        # print("----------")

    return T


# clrs example:
T = [
    [1, 0, 0, 0],
    [0, 1, 1, 1],
    [0, 1, 1, 0,],
    [1, 0, 1, 1]

]
result = transitive_closure(T)

for row in result:
    print(row)
