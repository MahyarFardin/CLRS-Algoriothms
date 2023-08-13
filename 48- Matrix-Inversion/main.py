import numpy as np


def determinant(matrix):
    if matrix.shape[0] != matrix.shape[1]:
        raise ValueError("The matrix is not square")
    n = matrix.shape[0]
    if n == 1:
        return matrix[0, 0]
    else:
        det = 0
        for j in range(n):
            sign = (-1) ** j
            sub_matrix = matrix[1:, np.arange(n) != j]
            det += sign * matrix[0, j] * determinant(sub_matrix)
    return det


def inverse_matrix(matrix):
    n = len(matrix)
    identity = np.identity(n)
    augmented_matrix = np.hstack((matrix, identity))

    for i in range(n):
        pivot = augmented_matrix[i][i]
        if pivot == 0:
            for j in range(i + 1, n):
                if augmented_matrix[j][i] != 0:
                    augmented_matrix[i, j] = augmented_matrix[j, i]
                    pivot = augmented_matrix[i][i]
                    break
            else:
                raise ValueError("Matrix is not invertible")

        for j in range(i, 2 * n):
            augmented_matrix[i][j] /= pivot
        for k in range(n):
            if k != i:
                factor = augmented_matrix[k][i]
                for j in range(i, 2 * n):
                    augmented_matrix[k][j] -= factor * augmented_matrix[i][j]

    inv = augmented_matrix[:, n:]

    return inv


A = np.array([[1, 2, 3],
              [-1, 1, -2],
              [2, -1, 3]])
A_inverse = inverse_matrix(A)
print("A = \n", A)
print("det(A) =", determinant(A))
print("A_inverse = \n", A_inverse)


