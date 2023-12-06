#takes in a file with different games like 'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53'
#iterates through every game, splits it into 2 arrays, the first with the numebrs on the left
#of the bar, the second numbers on the right. For every 'match' found, add 1 to the total matches
#prints the total matches of every line

def main():
    #initializes both the demo and input file
    inputFile = open('input.txt','r')
    demoFile = open('demo.txt','r')
    #sets the file's lines to an array holding each line
    lines = inputFile.read().splitlines() #can change inputFile to demoFile
    winningCount = 0
    for line in lines: #iterates through all lines
        #splits the line up into 2 arrays, the first winning numbers, the second drawn numbers
        line = line.split(':')
        line = line[1].split('|')
        winningNumbers = line[0].split()
        pulledNumbers = line[1].split()
        currentCount = 0
        #iterates through all winning numbers and checks if it is contained in pull numbers
        #the first instance adds 1, every other instance doubles the count
        for winningNumber in winningNumbers:
            for pulledNumber in pulledNumbers:
                if(winningNumber == pulledNumber):
                    if(currentCount == 0):
                        currentCount+=1
                    else:
                        currentCount*=2
        winningCount+=currentCount
    #prints the sum of the count     
    print(winningCount)       

main()
