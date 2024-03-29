def segments_intersect(p1, p2, p3, p4):
    d1 = direction(p3, p4, p1)
    d2 = direction(p3, p4, p2)
    d3 = direction(p1, p2, p3)
    d4 = direction(p1, p2, p4)
    if ((d1 > 0 and d2 < 0) or (d1 < 0 and d2 > 0)) and ((d3 > 0 and d4 < 0) or (d3 < 0 and d4 > 0)):
        return True
    elif d1 == 0 and on_segment(p3, p4, p1):
        return True
    elif d2 == 0 and on_segment(p3, p4, p2):
        return True
    elif d3 == 0 and on_segment(p1, p2, p3):
        return True
    elif d4 == 0 and on_segment(p1, p2, p4):
        return True
    else:
        return False


def direction(pi, pj, pk):
    return (pk[0] - pi[0]) * (pj[1] - pi[1]) - (pj[0] - pi[0]) * (pk[1] - pi[1])


def on_segment(pi, pj, pk):
    if (min(pi[0], pj[0]) <= pk[0] <= max(pi[0], pj[0]) and min(pi[1], pj[1]) <= pk[1] <= max(pi[1], pj[1])):
        return True
    else:
        return False


p1 = (1, 1)
p2 = (3, 4)
p3 = (2, 3)
p4 = (4, 2)

# p1 = (1,1)
# p2 = (3,4)
# p3 = (2,3)
# p4 = (1,2)

print(segments_intersect(p1, p2, p3, p4))
