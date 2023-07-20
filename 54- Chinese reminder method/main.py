def ChineseReminderMethod(num, rem):
    x = 1
    while(True):          
        counter = 0
        for i, j in zip(num, rem):
            if (x % i != j):
                break;
            counter += 1
        if (counter == len(num)):
            return x
        x += 1
num = [5, 2, 4]
rem = [0, 1, 1]
print(ChineseReminderMethod(num, rem))