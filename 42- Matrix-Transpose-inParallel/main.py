import threading


def parallel_transpose(A):
    n = len(A)

    def transpose_element(i, j):
        A[i][j], A[j][i] = A[j][i], A[i][j]

    threads = []

    for j in range(1, n):
        for i in range(j):
            thread = threading.Thread(target=transpose_element, args=(i, j))
            threads.append(thread)
            thread.start()

        for thread in threads:
            thread.join()

    return A


# Example matrix
A = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print("A = ")
for row in A:
    print(row)
transposed_matrix = parallel_transpose(A)
print("A_transpose = ")
for row in transposed_matrix:
    print(row)