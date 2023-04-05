class Bellman:

    def __init__(self, vertices, source):

        self.V = vertices

        self.graph = []

        self.distance = [float("Inf")] * self.V

        self.distance[source] = 0

    def add_edge(self, u, v, w):

        self.graph.append([u, v, w])

    def print_solution(self, distance):
        print("true")
        for k in range(self.V):
            print("{0} ----> {1}".format(k, distance[k]))

    def relax(self):
        for _ in range(self.V - 1):

            for u, v, w in self.graph:

                if self.distance[u] != float("Inf") and self.distance[u] + w < self.distance[v]:
                    self.distance[v] = self.distance[u] + w

    def bellman_ford(self):

        self.relax()
        for u, v, w in self.graph:

            if self.distance[u] != float("Inf") and self.distance[u] + w < self.distance[v]:
                print("false")

                return

        self.print_solution(self.distance)


graph1 = Bellman(4, 0)
graph1.add_edge(2, 3, -5)
graph1.add_edge(0, 3, 1)
graph1.add_edge(0, 1, 3)
graph1.add_edge(0, 2, 3)
graph1.add_edge(1, 2, -8)
graph1.bellman_ford()
print("--------------------")
graph2 = Bellman(4, 0)
graph2.add_edge(1, 0, -7)
graph2.add_edge(2, 3, -5)
graph2.add_edge(0, 3, 1)
graph2.add_edge(0, 1, 3)
graph2.add_edge(0, 2, 3)
graph2.add_edge(1, 2, -8)
graph2.bellman_ford()
