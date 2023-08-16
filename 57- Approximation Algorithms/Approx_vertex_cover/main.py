def approx_vertex_cover(G):
    C = []
    E = set()
    for u in G:
        for v in G[u]:
            E.add((u, v))
    while E:
        u, v = E.pop()
        C.append(u)
        C.append(v)
        for edge in list(E):
            if u in edge or v in edge:
                E.remove(edge)
    return C


G = {
    'A': ['B'],
    'B': ['A', 'C'],
    'C': ['B', 'D', 'E'],
    'D': ['C', 'E', 'G'],
    'E': ['C', 'D', 'F'],
    'F': ['E', 'D'],
    'G': ['D']
}

print(approx_vertex_cover(G))
