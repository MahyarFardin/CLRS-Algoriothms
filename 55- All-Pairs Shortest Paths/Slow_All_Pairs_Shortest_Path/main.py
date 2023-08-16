
def slow_all_pairs_shortest_path(w):
    n = len(w)
    distance = w
    # Extend shortest path
    for m in range(2, n):
        new_distance = [[float('inf')] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                for k in range(n):
                    new_distance[i][j] = min(
                        new_distance[i][j], distance[i][k] + w[k][j])
        # for row in new_distance :
        #    print(row)                #show steps
        # print("----------")
        distance = new_distance

    return distance

#clrs example:
w = [
    [0, 3, 8 , float('inf'), -4],
    [float('inf'), 0, float('inf'), 1 , 7],
    [float('inf'), 4, 0, float('inf') ,float('inf')],
    [2, float('inf'), - 5 , 0, float('inf')],
    [float('inf') , float('inf') , float('inf') , 6 , 0]
]

result = slow_all_pairs_shortest_path(w)

for row in result:
    print(row)
