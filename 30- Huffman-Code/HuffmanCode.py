import heapq as hq


class Node:
    def __init__(self, frequency, char, left_node=None, right_node=None):

        self.frequency = frequency

        self.char = char

        self.left_node = left_node

        self.right_node = right_node

        self.huffman_code = " "

    def __lt__(self, next):

        if not next:
            return -1

        if not(isinstance(next, Node)):
            return -1

        return self.frequency < next.frequency


def print_codes(node, code=''):

    new_code = code + str(node.huffman_code)

    if node.left_node:
        print_codes(node.left_node, new_code)

    if node.right_node:
        print_codes(node.right_node, new_code)

    if not (node.left_node and node.right_node):
        print(node.char, ":", new_code)


chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
frequencies = [1, 1, 2, 3, 5, 8, 13, 21]
nodes = []

for x in range(len(chars)):
    hq.heappush(nodes, Node(frequencies[x], chars[x]))

while len(nodes) > 1:
    left_node = hq.heappop(nodes)
    right_node = hq.heappop(nodes)

    left_node.huffman_code = 0
    right_node.huffman_code = 1

    newNode = Node(left_node.frequency + right_node.frequency,
                   left_node.char + right_node.char, left_node, right_node)

    hq.heappush(nodes, newNode)

print_codes(nodes[0])

