class Segment:
    def __init__(self, start, end):
        self.start = start
        self.end = end


def insert(T, s):
    T.append(s)


def delete(T, s):
    T.remove(s)


def above(T, s):
    above_segment = None
    for segment in T:
        if segment.start <= s.start and segment.end >= s.start:
            if above_segment is None or segment.end > above_segment.end:
                above_segment = segment
    return above_segment


def below(T, s):
    below_segment = None
    for segment in T:
        if segment.start <= s.end and segment.end >= s.end:
            if below_segment is None or segment.end < below_segment.end:
                below_segment = segment
    return below_segment


def intersects(s1, s2):
    return (s1.start < s2.start < s1.end) or (s1.start < s2.end < s1.end) or (s2.start < s1.start < s2.end) or (s2.start < s1.end < s2.end)


def any_segments_intersect(S):
    T = []
    S.sort(key=lambda s: (s.start, s.end))

    for segment in S:
        if segment.start:
            insert(T, segment)
            above_segment = above(T, segment)
            below_segment = below(T, segment)

            if (above_segment and intersects(above_segment, segment)) or (below_segment and intersects(below_segment, segment)):
                return True
        else:
            above_segment = above(T, segment)
            below_segment = below(T, segment)

            if above_segment and below_segment and intersects(above_segment, below_segment):
                return True

            delete(T, segment)

    return False


s1 = [Segment(1, 3), Segment(2, 4), Segment(3, 5), Segment(2, 8)]
print(any_segments_intersect(s1))


s2 = [Segment(1, 4), Segment(2, 5), Segment(3, 6), Segment(7, 9)]
print(any_segments_intersect(s2))



