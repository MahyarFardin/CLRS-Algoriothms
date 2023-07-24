import sys


def find_min_distance(h, visited):
    min_dist = sys.maxsize
    min_index = -1
    for i in range(len(h)):
        if h[i] < min_dist and not visited[i]:
            min_dist = h[i]
            min_index = i
    return min_index


def bellman_ford(G, S):
    num_vertices = len(G)
    h = [sys.maxsize] * num_vertices
    h[S] = 0

    for _ in range(num_vertices - 1):
        for u in range(num_vertices):
            for v in range(num_vertices):
                if G[u][v] != 0 and h[u] != sys.maxsize and h[u] + G[u][v] < h[v]:
                    h[v] = h[u] + G[u][v]

    for u in range(num_vertices):
        for v in range(num_vertices):
            if G[u][v] != 0 and h[u] != sys.maxsize and h[u] + G[u][v] < h[v]:
                return "negative weight cycle"

    return h


def dijkstra(G, S):
    num_vertices = len(G)
    h = [sys.maxsize] * num_vertices
    h[S] = 0
    visited = [False] * num_vertices

    for _ in range(num_vertices):
        u = find_min_distance(h, visited)
        visited[u] = True

        for v in range(num_vertices):
            if not visited[v] and G[u][v] != 0 and h[u] != sys.maxsize and h[u] + G[u][v] < h[v]:
                h[v] = h[u] + G[u][v]

    return h


def johnson(w):
    num_vertices = len(w)
    modified_graph = [row + [0] for row in w] + [[0] * (num_vertices + 1)]
    h = bellman_ford(modified_graph, num_vertices)

    if h == "negative weight cycle":
        return h

    num_vertices += 1
    new_w = [[0] * num_vertices for _ in range(num_vertices)]

    for u in range(num_vertices - 1):
        for v in range(num_vertices - 1):
            new_w[u][v] = w[u][v] + h[u] - h[v]

    D = [[0] * num_vertices for _ in range(num_vertices)]

    for u in range(num_vertices - 1):
        shortest_paths = dijkstra(new_w, u)
        for v in range(num_vertices - 1):
            if shortest_paths[v] == sys.maxsize:
                D[u][v] = float('inf')
            else:
                D[u][v] = shortest_paths[v] + h[v] - h[u]

    return D


# clrs example
G = [
    [0, 3, 8, float('inf'), -4],
    [float('inf'), 0, float('inf'), 1, 7],
    [float('inf'), 4, 0, float('inf'), float('inf')],
    [2, float('inf'), -5, 0, float('inf')],
    [float('inf'), float('inf'), float('inf'), 6, 0]
]

shortest_paths = johnson(G)
for row in shortest_paths:
    print(row)
