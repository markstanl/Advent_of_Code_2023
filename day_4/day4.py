def main():
    inputFile = open('input.txt','r')
    demoFile = open('demo.txt','r')
    lines = inputFile.read().splitlines()
    winningCount = 0
    for line in lines:
        line = line.split(':')
        line = line[1].split('|')
        winningNumbers = line[0].split()
        pulledNumbers = line[1].split()
        currentCount = 0
        for winningNumber in winningNumbers:
            for pulledNumber in pulledNumbers:
                if(winningNumber == pulledNumber):
                    if(currentCount == 0):
                        currentCount+=1
                    else:
                        currentCount*=2
        winningCount+=currentCount
        
    print(winningCount)       

main()
