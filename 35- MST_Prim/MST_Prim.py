import sys


def MST_Prim(G, w, r):
    if r not in G:
        print("'" + r + "'" + " is not in the graph.")
    Q = set(G)
    A = []
    root = r
    edge = []
    while len(Q) != 1:
        for i in G[root]:
            if i in Q:    
                edge.append((root, i))
                edge.append((i, root))
        if root in Q:     
            Q.remove(root)
        min_edeg = Extract_Min(edge, Q, w)
        A.append(min_edeg)
        root = min_edeg[0] if min_edeg[0] in Q else min_edeg[1]
        element_remove = [min_edeg]
        for element in element_remove:
            edge.remove(element)
    return A
         

def Extract_Min(edge, Q, w):
    min_edge = ()
    for i in edge:
        if i in w:
            min_edge = i
            break
    Min = {min_edge : sys.maxsize}
    min_val = list(Min.keys())[0]
    for i in edge:
        if i in w:
            if i[0] in Q or i[1] in Q:
                if w[i] < Min[min_val]:
                    min_val = i
                    break
    for i in edge:
        if i in w:
            if i[0] in Q or i[1] in Q:
                if w[i] < w[min_val]:
                    min_val = i
    return min_val


G = {                           # Book example clrs
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

A = MST_Prim(G, w, 'a')
print(A) # output -> [('a', 'b'), ('a', 'h'), ('g', 'h'), ('f', 'g'), ('c', 'f'), ('c', 'i'), ('c', 'd'), ('d', 'e')]

A = MST_Prim(G, w, 'e')
print(A) # output -> [('d', 'e'), ('c', 'd'), ('c', 'i'), ('c', 'f'), ('f', 'g'), ('g', 'h'), ('b', 'c'), ('a', 'b')]