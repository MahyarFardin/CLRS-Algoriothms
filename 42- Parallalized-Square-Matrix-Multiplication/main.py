
import threading
import numpy as np


def multiply(row, a, b, result):
    for i in range(len(b[0])):
        for j in range(len(b)):
            result[row][i] += a[row][j] * b[j][i]


a = np.array([[1, 0, 2],
             [2, 3, 1],
             [3, 0, 1]])

b = np.array([1, 1, 0, 2, 1, 4, 5, 1, 4])
b = b.reshape((3, 3))
result = np.zeros((3, 3))
threads = []

for i in range(len(a)):
    thread = threading.Thread(target=multiply, args=(i, a, b, result))
    thread.start()
    threads.append(thread)

for thread in threads:
    thread.join()


for row in result:
    print(row)
