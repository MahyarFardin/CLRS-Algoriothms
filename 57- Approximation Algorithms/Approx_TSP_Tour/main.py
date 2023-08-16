def MST_Prim(G, c, r):
    n = len(G)
    key = [float('inf')] * n
    parent = [None] * n
    visited = [False] * n

    key[r] = 0

    while True:
        u = -1
        min_key = float('inf')
        for v in range(n):
            if not visited[v] and key[v] < min_key:
                u = v
                min_key = key[v]

        if u == -1:
            break

        visited[u] = True

        for v in range(n):
            if not visited[v] and c[u][v] < key[v]:
                key[v] = c[u][v]
                parent[v] = u

    return parent


def Approx_TSP_Tour(G, c):
    n = len(G)
    r = 0

    T = MST_Prim(G, c, r)

    H = []
    stack = [r]
    while stack:
        u = stack.pop()
        H.append(u)
        for v in range(n):
            if T[v] == u:
                stack.append(v)

    H.append(r)

    return H


G = [
    [0, 2, 3, 0],
    [2, 0, 0, 2],
    [3, 0, 0, 1],
    [0, 2, 1, 0]
]

c = [
    [0, 1, 1, 0],
    [1, 0, 0, 2],
    [1, 0, 0, 1],
    [0, 2, 1, 0]
]

H = Approx_TSP_Tour(G, c)
print(H)
