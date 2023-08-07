def split_into_subarrays(Y):
    y_l = []
    y_R = []

    mid = len(Y) // 2
    mid_point = Y[mid]

    P_l = [point for point in Y if point[0] <= (mid_point[0]-1)]

    for point in Y:
        if point in P_l:
            y_l.append(point)
        else:
            y_R.append(point)

    return y_l, y_R


Y = [(1, 4), (2, 1), (3, 2), (4, 5), (5, 6), (7, 8)]
y_l, y_R = split_into_subarrays(Y)

print("y_l : ", y_l)
print("y_R : ", y_R)
