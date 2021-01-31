'''
Name: Jerry Zhang
Date: Jan.28 - 
Project name: Python 2048 
Purpose: Console based 2048 game
'''
## import random

import random
## introducing gamerules of 2048
color = input(" \033[1;37;48m Please select your color: \n Choices: Green, Blue, Yellow and White \n")
usercolor = color.title()

print("\033[1;32;48m Welcome to 2048! \n Type in 'A' 'S' 'W' 'D' to play! You win the game when you get 2048! \n")

print("\033[1;32;48m When you are ready, you can start the game\n")

print("\033[1;36;48m Author: Jerry Zhang \n")





# Rotates the 2D list clockwise
def rotate(grid):
    return list(map(list, zip(*grid[::-1])))

# Implements game logic 
# Generalized for all four directions using rotation logic
def move(grid, dir):
    for i in range(dir): grid = rotate(grid)
    for i in range(len(grid)):
        temp = []
        for j in grid[i]:
            if j != '_':
                temp.append(j)
        temp += ['_'] * grid[i].count('_') 
        for j in range(len(temp) - 1):
            if temp[j] == temp[j + 1] and temp[j] != '_' and temp[j + 1] != '_':
                temp[j] = str(2 * int(temp[j]))
                move.score += int(temp[j])
                temp[j + 1] = '_'
        grid[i] = []
        for j in temp:
            if j != '_':
                grid[i].append(j)
        grid[i] += ['_'] * temp.count('_')
    for i in range(4 - dir): grid = rotate(grid)
    return grid

# Finds empty slot in the game grid
def findEmptySlot(grid):
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == '_':
                return (i, j, 0)
    return (-1, -1, 1)

# Adds a random number to the grid
def addNumber(grid):
    num = random.randint(1, 2) * 2
    x = random.randint(0, 3)
    y = random.randint(0, 3)
    lost = 0
    if grid[x][y] != '_':
        x, y, lost = findEmptySlot(grid)
    if not lost: grid[x][y] = str(num)
    return (grid, lost)

# Prints the current game state
def printGrid(grid):
    print ("\n")
    for i in range(len(grid)):
        res = "\t\t"
        for j in range(len(grid[i])):
            for _ in range(5 - len(grid[i][j])): res += " "
            res += grid[i][j] + " "
        print (res)
        print ("\n")
    return 0

# Starts the game
def startGame():
   if usercolor == "Yellow":     
     print ("\n \033[1;33;48m Welcome to the 2048 Console version. Let's play!")
   if usercolor == "Green":
    print ("\n \033[1;32;48m Welcome to the 2048 Console version. Let's play!")
   if usercolor == "Blue":
    print ("\n \033[1;36;48m Welcome to the 2048 Console version. Let's play!")
   else:
    print ("\n Welcome to the 2048 Console version. Let's play!")

 
 


    
    # Create the game grid 
    # The game should work for square grid of any size though
   grid = [['_', '2', '_', '_'],
            ['_', '4', '_', '2'],
            ['_', '_', '_', '_'],
            ['2', '_', '2', '4']]
   direction = {'A': 0, 'S': 1, 'D': 2, 'W': 3, 'X': 4}
   #Convert user input
   printGrid(grid)
   loseStatus = 0
   move.score = 0 # Score of the user
   #update after each move
   while True:
     key = input("\n To continue, Press A for left, D for right, W for top, S for bottom or\nPress X to end the game.\n")
     if key in ["A", "a", "S", "s", "W", "w", "D", "d", "X", "x"]:
       dir = direction[key.upper()]
        # convert user input 
       if dir == 4:
          print ("\nCurrent score: " + str(move.score))
          break
       else:
          grid = move(grid, dir)
          grid, loseStatus = addNumber(grid)
          printGrid(grid)
          # if there is no free space in the list and no avaliable move, then you lose the game
          if loseStatus:
                    print ("\nGame Over")
                    print ("Final score: " + str(move.score))
                    break
                    print ("\nCurrent score: " + str(move.score))
     else:
        # if user didn't input ASWD
            print ("\nInvalid direction, please provide valid movement direction (A,S,W,D).")
     return 0 

# Program starts here
startGame()

