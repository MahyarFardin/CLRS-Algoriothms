def approx_min_weight_vc(G, w):
    c = set()
    x = compute_optimal_solution(G, w)  
    
    for v in G.nodes():
        if x[v] >= 0.5:
            c.add(v)
    
    return c


def compute_optimal_solution(G, w):
    # TODO compute the optimal solution
    pass