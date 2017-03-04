#Boggle
Finds all possible combinations of numbers that add up to the area of the grid using the rules of Boggle

## I SUMMARY       
I created a grid with a 2D arraylist that contained nodes. Each node contains a value and two pointers; one pointer points
to the node's child (the next node) and the other node points to the node's parent (the previous node). 
I found the answers by starting at each node in the grid, and with a recursive function, moving to each adjacent node,
creating a breadcrumb trail behind me with the node pointers. Each time I move to an adjacent node, I would subtract 
the adjacent node's value from the area of the grid. I would keep track of this value with the variable named
current. If current went below 0, I would stop moving to adjacent nodes, but if current equaled 0, then I would stop moving to undiscovered
adjacent nodes and follow the parent pointers back to the root node, adding each node along the way to an array called solution.
I would then check to make sure that solution does not already contain the same nodes found in a previous answer, and if it did not then
I would add the solution list to a list called allSolutions.

##II How to Use
Main method can be found in the test class. To change the height and width of the grid, change the values in the 
parameters of the create table method                                                            
Example: myBoggle.createTable(HEIGHT,WIDTH) 
##III CLASSES
###Node
Data scructure that contains the value of a cell as well as pointers to create a doubly-linked list.             
###Boggle
Methods to create Boggle Grid, find solutions, and print them to console.
###Test
Includes Main method to run tests.







