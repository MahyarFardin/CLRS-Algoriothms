import math
import matplotlib.pyplot as plt


def polar_angle(p0, p):
    x_diff = p[0] - p0[0]
    y_diff = p[1] - p0[1]
    return math.atan2(y_diff, x_diff)


def distance(p0, p):
    x_diff = p[0] - p0[0]
    y_diff = p[1] - p0[1]
    return x_diff**2 + y_diff**2


def next_to_top(stack):
    return stack[-2]


def top(stack):
    return stack[-1]


def graham_scan(Q):
    p0 = min(Q, key=lambda p: (p[1], p[0]))
    sorted_Q = sorted(Q, key=lambda p: polar_angle(p0, p))
    unique_points = [sorted_Q[0]]

    for i in range(1, len(sorted_Q)):
        while i < len(sorted_Q) - 1 and polar_angle(p0, sorted_Q[i]) == polar_angle(p0, sorted_Q[i + 1]):
            i += 1
        unique_points.append(sorted_Q[i])

    stack = [unique_points[0], unique_points[1]]
    for i in range(2, len(unique_points)):
        while len(stack) > 1 and (next_to_top(stack)[0] - top(stack)[0]) * (unique_points[i][1] - top(stack)[1]) - (next_to_top(stack)[1] - top(stack)[1]) * (unique_points[i][0] - top(stack)[0]) >= 0:
            stack.pop()
        stack.append(unique_points[i])

    return stack


Q = [(0, 0), (1, 1), (2, 2), (3, 3), (1, 2), (2, 1),
          (2, 4), (3, 2), (5, 1), (4, 3), (2, 3)]
CH = graham_scan(Q) #canvex_hall

x = [point[0] for point in Q]
y = [point[1] for point in Q]
plt.scatter(x, y, color='#396e47')

x_hull = [point[0] for point in CH]
y_hull = [point[1] for point in CH]
x_hull.append(CH[0][0])
y_hull.append(CH[0][1])
plt.plot(x_hull, y_hull, color='#714573')

plt.show()