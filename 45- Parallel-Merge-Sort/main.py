import threading
from timeit import default_timer as timer


def ordinary_merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left_half = arr[:mid]
    right_half = arr[mid:]

    left_half = ordinary_merge_sort(left_half)
    right_half = ordinary_merge_sort(right_half)

    return merge(left_half, right_half)


def merge(left, right):
    result = []
    i, j = 0, 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])

    return result


def binary_search(x, T, p, r):
    low = p
    high = max(p, r + 1)
    while low < high:
        mid = (low + high) // 2
        if x <= T[mid]:
            high = mid
        else:
            low = mid + 1
    return high


def p_merge(T, p1, r1, p2, r2, A, p3):

    n1 = r1 - p1 + 1
    n2 = r2 - p2 + 1
    if n1 < n2:
        p1, p2 = p2, p1
        r1, r2 = r2, r1
        n1, n2 = n2, n1
    if n1 == 0:
        return
    q1 = (p1 + r1) // 2
    q2 = binary_search(T[q1], T, p2, r2)
    q3 = p3 + (q1 - p1) + (q2 - p2)
    A[q3] = T[q1]

    thread1 = threading.Thread(target=p_merge, args=(T, p1, q1 - 1, p2, q2 - 1, A, p3))
    thread1.start()

    p_merge(T, q1 + 1, r1, q2, r2, A, q3 + 1)

    thread1.join()


def p_merge_sort(A, p, r, B, s):

    n = r - p + 1
    if n == 1:
        B[s] = A[p]
    else:
        T = [None] * n
        q = (p + r) // 2
        q_prime = q - p + 1

        thread1 = threading.Thread(target=p_merge_sort, args=(A, p, q, T, 0))
        thread1.start()

        p_merge_sort(A, q + 1, r, T, q_prime)

        thread1.join()

        p_merge(T, 0, q_prime - 1, q_prime, n - 1, B, s)


def parallel_merge_sort(arr):

    result = [None] * len(arr)
    start = timer()
    p_merge_sort(A, 0, len(arr) - 1, result, 0)
    end = timer()
    time = end - start
    return result, time


A = [4, 2, 8, 1, 3, 7, 6, 5]
sorted_arr, parallel_time = parallel_merge_sort(A)
print(sorted_arr)
start_time = timer()
sorted_arr2 = ordinary_merge_sort(A)
end_time = timer()
ordinary_approach_time = (end_time - start_time)
print(sorted_arr2)
print("Execution time of the parallel approach : ", parallel_time)
print("Execution time of the ordinary approach : ", ordinary_approach_time)



