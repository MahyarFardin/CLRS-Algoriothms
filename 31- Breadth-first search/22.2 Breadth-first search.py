import sys
import copy


def BFS(G, s):
    key_list = []
    u = {}
    for i in graph:
        key_list.append(i)
    u_value = {"color": "White", "d": sys.maxsize, "p": "NIL"}
    for i in key_list:
        u[i] = copy.deepcopy(u_value)
    u[s]["color"] = "Gray"
    u[s]["d"] = 0
    Q = []
    Q.append(s)
    while Q:
        node = Q.pop()
        for v in G[node]:
            if u[v]["color"] == "White":
                u[v]["color"] = "Gray"
                u[v]["d"] = u[node]["d"] + 1
                u[v]["p"] = node
                Q.append(v)
        u[node]["color"] = "Black"
    return u


def Print_Path(G, s, v, u):
    if s not in G:
        print(f"The {s} is not in the graph")
        return
    if v not in G:
        print(f"The {v} is not in the graph")
        return
    if s == v:
        print(s)
    elif u[v]["p"] == "NIL":
        print(f"No path from {s} to {v} exist.")
        exit()
    else:
        Print_Path(G, s, u[v]["p"], u)
        print(v)


graph = {
    's': ['r', 'w'],
    'r': ['v', 's'],
    'v': ['r'],
    'w': ['s', 't', 'x'],
    't': ['w', 'x','u'],
    'x': ['w', 't', 'u', 'y'],
    'u': ['t', 'x', 'y'],
    'y': ['u', 'x']
}
# -----------------------------
u = BFS(graph, 's')                 
Print_Path(graph, 's', 'y', u)   # output -> s w x y
print("\n")
# -----------------------------
u = BFS(graph, 'u')                 
Print_Path(graph, 'u', 'v', u)   # output -> u x w s r v
print("\n")   
# -----------------------------
u = BFS(graph, 's')                 
Print_Path(graph, 'a', 'y', u)   # output -> The a is not in the graph
print("\n")
# -----------------------------
u = BFS(graph, 'v')                 
Print_Path(graph, 'v', 'y', u)   # output -> v r s w x y