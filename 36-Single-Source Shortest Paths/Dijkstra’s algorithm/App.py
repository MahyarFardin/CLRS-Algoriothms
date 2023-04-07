from queue import PriorityQueue


class Graph:

    def __init__(self, vertices, source):
        self.V = vertices
        self.graph = []
        self.distance = [float("Inf")] * self.V
        self.distance[source] = 0
        self.visited = []
        self.q = PriorityQueue()
        self.q.put((0, source))

    def add_edge(self, u, v, w):
        self.graph.append([u, v, w])

    def relax(self):
        for i in range(self.V):
            for u, v, w in self.graph:
                if self.distance[u] != float("Inf") and self.distance[u] + w < self.distance[v]:
                    self.distance[v] = self.distance[u] + w
                    self.q.put(self.distance[u] + w, i)

    def dijkstra(self):
        while not self.q.empty():
            current = self.q.get()
            self.visited.append(current)
            for i in range(self.V):
                if i not in self.visited:
                    self.relax()
        for k in range(self.V):
            print("{0} ----> {1}".format(k, self.distance[k]))


#  clrs example
#  s=0 , t=1 ,y=2 , x=3, z=4
g = Graph(5, 0)
g.add_edge(0, 1, 10)
g.add_edge(0, 2, 5)
g.add_edge(1, 2, 2)
g.add_edge(1, 3, 1)
g.add_edge(2, 1, 3)
g.add_edge(2, 3, 9)
g.add_edge(2, 4, 2)
g.add_edge(3, 4, 4)
g.add_edge(4, 3, 6)
g.add_edge(4, 0, 7)
g.dijkstra()
