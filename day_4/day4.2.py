#takes in a file with different games like 'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53'
#iterates through every game, splits it into 2 arrays, the first with the numebrs on the left
#of the bar, the second numbers on the right. For every 'match' found, add 1 to the total matches
# for every recursion, adds to a list. returns the length of that list


#main method, gets the input and demo text files, and sets the string to a variable.
def main():
    inputFile = open('input.txt','r')
    demoFile = open('demo.txt','r')
    #sets a variable sets each individual line to a value in a list
    lines = inputFile.read().splitlines() #can switch between inputFile and demoFile 

    #runs the check for winnings method on each line (this is the 'deafault' run) 
    for num in range(len(lines)):
        checkForWinnings(lines, num)     


def checkForWinnings(lines, num):
    #appends an array every time it runs, this will tell us at the end how many times it ran
    test1.append(num)
    #variable initialization, creates 2 arrays, the winning numbers and the pulled numbers
    line = lines[num].split(':')
    line = line[1].split('|')
    winningNumbers = line[0].split()
    pulledNumbers = line[1].split()
    currentCount = 0
    returnCount = 0
    #iterates through all the numbers, if the winning numbers appear in the pulled numbers, it adds 
    #1 to the count, does this for every value
    for winningNumber in winningNumbers:
        for pulledNumber in pulledNumbers:
            if(winningNumber == pulledNumber):
                currentCount+=1
    #recursively calls this method on every line after
    for num2 in range(1,currentCount+1):
        checkForWinnings(lines, num+num2)

test1 = []

main()

print(len(test1))
