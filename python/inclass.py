def multiple_of(n,*num):

    return [i for i in list(range(n)) if all(i%d==0 for d in num)]

print(multiple_of(100,5,3,2))