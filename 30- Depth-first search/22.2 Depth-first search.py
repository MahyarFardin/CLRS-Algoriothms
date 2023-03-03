import sys
import copy


graph = {
    'u': ['v', 'x'],
    'v': ['y'],
    'x': ['v'],           # Book example CLRS
    'y': ['x'],
    'w': ['y', 'z'],
    'z': ['z']
}
key_list = []
graph_list = {}
for i in graph:
    key_list.append(i)
graph_list_value = {"color": "White", "d": sys.maxsize, "f": sys.maxsize, "p": "NIL"}
for i in key_list:
    graph_list[i] = copy.deepcopy(graph_list_value)
time = 0


def DFS(G):
    for u in G:
        if graph_list[u]["color"] == "White":
           v = DFS_Visit(G, u)


def DFS_Visit(G, u):
    global time
    time += 1
    graph_list[u]["d"] = time
    graph_list[u]["color"] = "Gray"
    for v in G[u]:
        if graph_list[v]["color"] == "White":
            graph_list[v]["p"] = u
            DFS_Visit(G, v)
    graph_list[u]["color"] = "Black"
    time = time + 1
    graph_list[u]["f"] = time


DFS(graph)
print(graph_list) # output -> {
                  #            'u': {'color': 'Black', 'd': 1, 'f': 8, 'p': 'NIL'},
                  #            'v': {'color': 'Black', 'd': 2, 'f': 7, 'p': 'u'}, 
                  #            'x': {'color': 'Black', 'd': 4, 'f': 5, 'p': 'y'},
                  #            'y': {'color': 'Black', 'd': 3, 'f': 6, 'p': 'v'},
                  #            'w': {'color': 'Black', 'd': 9, 'f': 12, 'p': 'NIL'},
                  #            'z': {'color': 'Black', 'd': 10, 'f': 11, 'p': 'w'}
                  #           }