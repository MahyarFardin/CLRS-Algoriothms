import threading
import numpy as np

def multiply_matrices(A, B, C, start_row, end_row):

    for i in range(start_row, end_row):
        for j in range(len(B[0])):
            for k in range(len(B)):
                C[i][j] += A[i][k] * B[k][j]


def recursive_matrix_multiply(C, A, B, num_threads=4):

    n = len(A)

    if n <= 64 or num_threads == 1:
        multiply_matrices(A, B, C, 0, n)
    else:
        half_n = n // 2
        C11 = [[0] * half_n for _ in range(half_n)]
        C12 = [[0] * half_n for _ in range(half_n)]
        C21 = [[0] * half_n for _ in range(half_n)]
        C22 = [[0] * half_n for _ in range(half_n)]

        A11 = [row[:half_n] for row in A[:half_n]]
        A12 = [row[half_n:] for row in A[:half_n]]
        A21 = [row[:half_n] for row in A[half_n:]]
        A22 = [row[half_n:] for row in A[half_n:]]

        B11 = [row[:half_n] for row in B[:half_n]]
        B12 = [row[half_n:] for row in B[:half_n]]
        B21 = [row[:half_n] for row in B[half_n:]]
        B22 = [row[half_n:] for row in B[half_n:]]

        threads = []
        threads.append(threading.Thread(target=recursive_matrix_multiply, args=(C11, A11, B11, num_threads // 2)))
        threads.append(threading.Thread(target=recursive_matrix_multiply, args=(C12, A11, B12, num_threads // 2)))
        threads.append(threading.Thread(target=recursive_matrix_multiply, args=(C21, A21, B11, num_threads // 2)))
        threads.append(threading.Thread(target=recursive_matrix_multiply, args=(C22, A21, B12, num_threads // 2)))

        for thread in threads:
            thread.start()
        for thread in threads:
            thread.join()

        for i in range(half_n):
            C[i] = C11[i] + C12[i]
            C[i + half_n] = C21[i] + C22[i]


A = np.array([[2, 3, 1, 4], [5, 6, 2, 7], [1, 3, 5, 2], [8, 4, 7, 6]])
B = np.array([[4, 5, 3, 1], [6, 7, 2, 8], [2, 4, 6, 3], [7, 5, 8, 1]])
C = np.array([[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]])

recursive_matrix_multiply(C, A, B, num_threads=4)
print("A = ")
for row in A:
    print(row)
print("B = ")
for row in B:
    print(row)
print("A * B = ")
for row in C:
    print(row)

exact_result = np.matmul(A, B)
for i in range(A.shape[0]):
    for j in range(A.shape[1]):
        if C[i, j] != exact_result[i, j]:
            print("The implementation is not correct")

print("The result given by numpy's matmul function = \n", exact_result)





