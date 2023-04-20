def FordFulkerson(G, s, t):
    def BFS(G, s, t, parent):
        visited = [False] * len(G)
        queue = []
        queue.append(s)
        visited[s] = True
        while queue:
            u = queue.pop(0)
            for ind, val in enumerate(G[u]):
                if visited[ind] == False and val > 0:
                    queue.append(ind)
                    visited[ind] = True
                    parent[ind] = u
        return True if visited[t] else False
 
    parent = [-1] * len(G)
    max_flow = 0
    while BFS(G, s, t, parent):
        path_flow = float("Inf")
        a = t
        while a != s:
            path_flow = min(path_flow, G[parent[a]][a])
            a = parent[a]
        max_flow += path_flow
        v = t
        while v !=  s:
            u = parent[v]
            G[u][v] -= path_flow
            G[v][u] += path_flow
            v = parent[v]
    return max_flow


graph_1 = [[0, 16, 13, 0, 0, 0],
           [0, 0, 10, 12, 0, 0],
           [0, 4, 0, 0, 14, 0],
           [0, 0, 9, 0, 0, 20],
           [0, 0, 0, 7, 0, 4],
           [0, 0, 0, 0, 0, 0]]

max_flow = FordFulkerson(graph_1, 0, 5)
print("graph_1 Max flow:", max_flow) # output -> 23


graph_2 = [[0, 9, 8, 0, 0, 0],
           [0, 0, 0, 4, 4, 0],
           [0, 2, 0, 0, 5, 3],
           [0, 0, 0, 0, 0, 5],
           [0, 0, 0, 0, 0, 6],
           [0, 0, 0, 0, 0, 0]]

max_flow = FordFulkerson(graph_2, 0, 5)
print("graph_2 Max flow:", max_flow) # output -> 13


graph_3 = [[0, 10, 10, 0, 0, 0],
           [0, 0, 2, 4, 8, 0],
           [0, 0, 0, 0, 9, 0],
           [0, 0, 0, 0, 0, 10],
           [0, 0, 0, 8, 0, 10],
           [0, 0, 0, 0, 0, 0]]

max_flow = FordFulkerson(graph_3, 0, 5)
print("graph_3 Max flow:", max_flow) # output -> 19