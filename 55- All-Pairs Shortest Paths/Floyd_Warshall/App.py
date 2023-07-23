def floyd_Warshall(W):
    n = len(W)
    D = W

    for k in range(n):
        for i in range(n):
            for j in range(n):
                D[i][j] = min(D[i][j], D[i][k]+D[k][j])
        # for row in D :
        #    print(row)       #show steps
        # print("-------------------")
    return D


# clrs example:
w = [
    [0, 3, 8, float('inf'), -4],
    [float('inf'), 0, float('inf'), 1, 7],
    [float('inf'), 4, 0, float('inf'), float('inf')],
    [2, float('inf'), - 5, 0, float('inf')],
    [float('inf'), float('inf'), float('inf'), 6, 0]
]


result = floyd_Warshall(w)

for row in result:
    print(row)
