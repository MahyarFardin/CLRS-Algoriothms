def MST_KRUSKAL(G, w):
    parent = {}
    rank = {}
    for v in G:
        parent[v] = v
        rank[v] = 0
    A = []
    edges = sorted(w.values()) # edges -> [1, 2, 2, 4, 4, 6, 7, 7, 8, 8, 9, 10, 11, 14]
    for edge in edges:
        u = list(w.keys())[list(w.values()).index(edge)][0]
        v = list(w.keys())[list(w.values()).index(edge)][1]
        w.pop((u, v))
        if find(parent, u) != find(parent, v):
            A.append((u, v))
            union(parent, rank, u, v)
    return A


def find(parent, i):
    if parent[i] == i:
        return i
    return find(parent, parent[i])


def union(parent, rank, x, y):
    xroot = find(parent, x)
    yroot = find(parent, y)
 
    if rank[xroot] < rank[yroot]:
        parent[xroot] = yroot
    elif rank[xroot] > rank[yroot]:
        parent[yroot] = xroot
    else :
        parent[yroot] = xroot
        rank[xroot] += 1


# Book example clrs
G = {
    'a' : ['b', 'h'],
    'b' : ['a', 'c', 'h'],
    'c' : ['b', 'd', 'f', 'i'],
    'd' : ['c', 'e', 'f'],
    'e' : ['d', 'f'],
    'f' : ['c', 'd', 'e', 'g'],
    'g' : ['f', 'h', 'i'],
    'h' : ['a', 'b', 'g', 'i'],
    'i' : ['c', 'g', 'h']
}

w = {
    ('a', 'b') : 4,
    ('a', 'h') : 8,
    ('b', 'c') : 8,
    ('b', 'h') : 11,
    ('c', 'd') : 7,
    ('c', 'f') : 4,
    ('c', 'i') : 2,
    ('d', 'e') : 9,
    ('d', 'f') : 14,
    ('e', 'f') : 10,
    ('f', 'g') : 2,
    ('g', 'h') : 1,
    ('g', 'i') : 6,
    ('h', 'i') : 7
}

A = MST_KRUSKAL(G, w)
print(A) # output -> [('g', 'h'), ('c', 'i'), ('f', 'g'), ('a', 'b'), ('c', 'f'), ('c', 'd'), ('a', 'h'), ('d', 'e')]