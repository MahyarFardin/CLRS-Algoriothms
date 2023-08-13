import threading

def mat_vec_mult(A, x):
    n = len(A)
    y = [0] * n

    def compute_row(i):
        local_sum = 0
        for j in range(n):
            local_sum += A[i][j] * x[j]
        y[i] = local_sum

    threads = []
    for i in range(n):
        thread = threading.Thread(target=compute_row, args=(i,))
        thread.start()
        threads.append(thread)

    for thread in threads:
        thread.join()

    return y


def mat_vec_recursive(A, x, y, n, i, i_prime):
    if i == i_prime:
        for j in range(n):
            y[i] += A[i][j] * x[j]
    else:
        mid = (i + i_prime) // 2

        thread_left = threading.Thread(target=mat_vec_recursive, args=(A, x, y, n, i, mid))
        thread_left.start()

        mat_vec_recursive(A, x, y, n, mid + 1, i_prime)

        thread_left.join()


def mat_vec_mult_recursive(A, x):
    n = len(A)
    y = [0] * n

    mat_vec_recursive(A, x, y, n, 0, n - 1)

    return y


A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
x = [2, 3, 4]
result = mat_vec_mult(A, x)
print(result)

print("###############")

A2 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
x2 = [2, 3, 4]
result2 = mat_vec_mult_recursive(A2, x2)
print(result2)