import numpy as np
import matplotlib.pyplot as plt

def transpose(matrix):
    return [[data_matrix[j][i] for j in range(len(data_matrix))] for i in range(len(data_matrix[0]))]


def matrix_multiply(matrix1, matrix2):
    result = []
    for i in range(len(matrix1)):
        row = []
        for j in range(len(matrix2[0])):
            value = 0
            for k in range(len(matrix2)):
                value += matrix1[i][k] * matrix2[k][j]
            row.append(value)
        result.append(row)
    return result


def solve_least_squares(data_matrix, target_vector):

    data_matrix_transpose = transpose(data_matrix)
    product = matrix_multiply(data_matrix_transpose, data_matrix)
    target_matrix_product = [0] * len(data_matrix[0])

    for i in range(len(data_matrix[0])):
        for j in range(len(target_vector)):
            target_matrix_product[i] += data_matrix_transpose[i][j] * target_vector[j]

    n = len(product)
    for i in range(n):
        diag = product[i][i]
        for j in range(i, n):
            product[i][j] /= diag
        target_matrix_product[i] /= diag
        for j in range(i + 1, n):
            factor = product[j][i]
            for k in range(i, n):
                product[j][k] -= factor * product[i][k]
            target_matrix_product[j] -= factor * target_matrix_product[i]

    solution_vector = [0] * n
    for i in range(n - 1, -1, -1):
        solution_vector[i] = target_matrix_product[i]
        for j in range(i + 1, n):
            solution_vector[i] -= product[i][j] * solution_vector[j]

    return solution_vector


data_matrix = [[1, 2], [3, 4], [5, 6]]
target_vector = [2.3, 3.8, 9.01]

solution = solve_least_squares(data_matrix, target_vector)
print("Solution vector provided by the implemented algorithm:", solution)
numpy_result = np.linalg.lstsq(np.array(data_matrix), np.array(target_vector), rcond=None)[0]
print("Solution vector provided by numpy: ", numpy_result)

data_matrix2 = np.array([[1, 2],
                         [3, 4],
                         [5, 6]])


plt.scatter(data_matrix2[:, 0], target_vector, label='Data Points')

x_vals = np.linspace(min(data_matrix2[:, 0]), max(data_matrix2[:, 0]), 100)
y_vals = solution[0] * x_vals + solution[1]
plt.plot(x_vals, y_vals, color='red', label='Least Squares Solution')

plt.xlabel('Feature')
plt.ylabel('Target')
plt.title('Least Squares')
plt.legend()
plt.grid(True)
plt.show()



