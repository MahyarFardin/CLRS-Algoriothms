from collections import defaultdict


class ShortestPath:

    def __init__(self, vertices, source):
        self.V = vertices
        self.graph = defaultdict(list)
        self.distance = [float("Inf")] * (self.V)
        self.distance[source] = 0
        self.source = source

    def add_edge(self, u, v, w):

        self.graph[u].append([v, w])

    def relax(self, i):
        for node, weight in self.graph[i]:
            if self.distance[node] > self.distance[i] + weight:
                self.distance[node] = self.distance[i] + weight

    def topologicallySort(self, v, visited, verStack):

        visited[v] = True

        if v in self.graph.keys():
            for node, weight in self.graph[v]:
                if visited[node] == False:
                    self.topologicallySort(node, visited, verStack)
        verStack.append(v)

    def shortestPath(self):
        
        visited = [False] * self.V
        verStack = []

        for i in range(self.V):
            if visited[i] == False:
                self.topologicallySort(self.source, visited, verStack)

        while verStack:
            i = verStack.pop()
            self.relax(i)

        for i in range(self.V):
            print(("%d" % self.distance[i]) if self.distance[i] != float("Inf") else "Inf", end=" ")


# clrs example
# r=0 , s=1 , t=2 , x=3 , y=4 , z=5
graph1 = ShortestPath(6, 1)
graph1.add_edge(1, 2, 2)
graph1.add_edge(1, 3, 6)
graph1.add_edge(0, 1, 5)
graph1.add_edge(0, 2, 3)
graph1.add_edge(2, 3, 7)
graph1.add_edge(2, 4, 4)
graph1.add_edge(2, 5, 2)
graph1.add_edge(3, 4, -1)
graph1.add_edge(3, 5, 1)
graph1.add_edge(4, 5, -2)
graph1.shortestPath()