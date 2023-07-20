import numpy as np

def fft(coeff):
    n = len(coeff)
    wn = lambda k : np.exp( -2j * np.pi * k / n)
    
    if n <= 1: 
        return coeff
    
    pe = fft(coeff[0::2])
    po =  fft(coeff[1::2])
    
    y = [wn(k)*po[k] for k in range(n//2)]
    
    return [pe[k] + y[k] for k in range(n//2)] + \
           [pe[k] - y[k] for k in range(n//2)]


coeff = np.random.rand((8)) * 10 // 1
transformed = fft(coeff)