import multiprocessing as mp


def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n-1) + fibonacci(n-2)


def p_fibonacci(m, num_processes):

    pool = mp.Pool(processes=num_processes)
    results = [pool.apply_async(fibonacci, args=(i,))for i in range(m)]
    '''
    results = []
    for i in range(m):
        results.append(pool.apply_async(fibonacci, args=(i, )))
    '''

    output = [p.get() for p in results]
    '''
    output = []
    for p in results:
        output.append(p.get())
    '''
    return output


if __name__ == '__main__':
    n = 11
    num_processes = 4
    result = p_fibonacci(n, num_processes)
    print(result)




