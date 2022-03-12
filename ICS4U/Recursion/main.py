"""
Program Name: Unit 4 Task
Created on: Jan. 11 2022
Name: Jerry Zhang
Purpose: To use recursion to make a customizable snowflake fractle in python turtle.
"""

import turtle
## set background colour
s = turtle.Screen()
s.bgcolor("#C3E6FC")
t = turtle.Turtle()
t.speed(0)

## store y coordinates 
ycor = []
## ask for user input
side = int(input("how many sides of the snowflake do you want?"))

'''
snowflake_sides
Purpose: to create one side of the snowflake according to the given length and level
@param: int, int
@return: none 
'''
def snowflake_sides(length, level):
    ## base case
    if level == 0:
        t.forward(length)
        ## prevent maximum call stack size exceed
        return 
    ## recursive call:
    length /= 3.0
    snowflake_sides(length, level-1)
    t.left(60)
    snowflake_sides(length, level-1)
    t.right(120)
    snowflake_sides(length, level-1)
    t.left(60)
    snowflake_sides(length, level-1)
'''
snowflake
Purpose: to create the snowflake shape with colors according the number of sides and side length
@param: int, int
@return: none 
'''
def snowflake(side, length):
    colors = ['#3EB489','#008080','#FF7D61','#A32EFF','#00BFFF','#9ACD32']
     
     ## make the shape
    for i in range(side):
        t.fillcolor(colors[i])
        t.pencolor(colors[i])
        t.begin_fill()
        snowflake_sides(length,side)
        ## round y value to an integer
        ycor.append(round(t.ycor(),0))
        t.right(360/side)
        t.end_fill()

'''
display_centre
Purpose: to create an example of one side of the shape at the centre of the entire shape 
@param: int
@return: none 
'''    
def display_centre(side):
    t.pu()
    ## will only work if the shape has 3 or more sides
    if side == 3:
        t.goto(40,-(225/3.5))
        t.pd()
        t.pencolor('#0F52BA')
        snowflake_sides(145,side)
    elif side > 3:
        ysum = 0
        for y in ycor:
            ysum += y 
        avgy = ysum / side
        t.goto(20,avgy)
        t.pd()
        t.pencolor('#0F52BA')
        snowflake_sides(185,side)
    t.hideturtle()

## make the snowflake
snowflake(side, 225)
display_centre(side)
