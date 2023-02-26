def LCS_Length(X, Y):
    # CLRS book example:
    # inputs X =["A", "B", "C", "B", "D", "A", "B"] , Y = ["B", "D", "C", "A", "B", "A"]
    #                       [                               [
    #                       [0, 0, 0, 0, 0, 0, 0],          ['', '', '', '', '', '', ''],
    #                       [0, 0, 0, 0, 1, 1, 1],          ['', '|', '|', '|', '\\', '<-', '\\'],
    #                       [0, 1, 1, 1, 1, 2, 2],          ['', '\\', '<-', '<-', '|', '\\', '<-'],
    # return c and b -> c = [0, 1, 1, 2, 2, 2, 2],      b = ['', '|', '|', '\\', '<-', '|', '|'],
    #                       [0, 1, 1, 2, 2, 3, 3],          ['', '\\', '|', '|', '|', '\\', '<-'],
    #                       [0, 1, 2, 2, 2, 3, 3],          ['', '|', '\\', '|', '|', '|', '|'],
    #                       [0, 1, 2, 2, 3, 3, 4],          ['', '|', '|', '|', '\\', '|', '\\'],
    #                       [0, 1, 2, 2, 3, 4, 4]           ['', '\\', '|', '|', '|', '\\', '|']
    #                       ]                               ]
    m = len(X)
    n = len(Y)
    b = [["" for i in range(n + 1)] for i in range(m + 1)]
    c = [[0 for i in range(n + 1)] for i in range(m + 1)]
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if X[i - 1] == Y[j - 1]:
                c[i][j] = c[i - 1][j - 1] + 1
                b[i][j] = "\\"
            elif c[i - 1][j] >= c[i][j - 1]:
                c[i][j] = c[i - 1][j]
                b[i][j] = "|"
            else:
                c[i][j] = c[i][j - 1]
                b[i][j] = "<-"
    return c and b


def Print_LCS(b, X, i, j):
    if i == 0 or j == 0:
        return
    if b[i][j] == "\\":
        Print_LCS(b, X, i - 1, j - 1)
        print(X[i - 1])
    elif b[i][j] == "|":
        Print_LCS(b, X, i - 1, j)
    else:
        Print_LCS(b, X, i, j - 1)


X = ["A", "B", "C", "B", "D", "A", "B"]
Y = ["B", "D", "C", "A", "B", "A"]
b = LCS_Length(X, Y)
Print_LCS(b, X, len(X), len(Y))  # output -> B C B A
