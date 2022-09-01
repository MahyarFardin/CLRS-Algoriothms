from random import randint
profit=0

# to generate random weights and profits for products
def randomGenerator(arg, totalThings):
	for x in range(totalThings):
		arg.append(randint(1,10))

# Main function
def bagFiller(pToW, bag, totalWeight, profits, weights, maximumWeight):

	global profit
	# end condition for recursion
	if(totalWeight==maximumWeight):
		return 0

	# find the maximum profit to weight proportion
	indexTemp= pToW.index(max(pToW))

	# whether to put sth completely or some devision of it in the bag
	if(totalWeight+weights[indexTemp]<=maximumWeight):
		totalWeight+=weights[indexTemp]
		profit+=profits[indexTemp]
		bag[indexTemp]=1
	else :
		bag[indexTemp]=round((maximumWeight-totalWeight)/weights[indexTemp],2)
		totalWeight+=maximumWeight-totalWeight
		profit+=bag[indexTemp]*profits[indexTemp]

	# eliminate the maximum
	pToW[indexTemp]=-1

	# recursion call
	bagFiller(pToW, bag, totalWeight, profits, weights, maximumWeight)	



# initial variables
maximumWeight=15
totalThings=10
weights=[]
profits=[]
pToW=[]

# generate empty space in bags
bag=[0 for _ in range(totalThings)]


randomGenerator(weights, totalThings)
randomGenerator(profits, totalThings)

# find profit/weight
pToW=[round(i/j,2) for i,j,k in zip(weights, profits, range(10))]

# monitors
print(f"maximum weight is: {maximumWeight}\n")
print("weights:")
print(weights)
print()
print("profits:")
print(profits)
print()
print("profit/weight:")
print(pToW)

# call main function
bagFiller(pToW, bag,0,profits, weights, maximumWeight)

# results monitor
print("\n======================================")
print("things that are going to be in the bag")
print(bag)
print()
print(f"maximum profit: {profit}")