#predator-prey-simulation
##A Lotka-Volterra model written in Java that describes predator-prey relationships

The Lotka-Volterra model depends on six parameters: 
* the population of prey
* the population of predator
* prey birth rate
* prey death rate
* predator birth rate
* prey birth rate

###How the Simulation Works

The simulation has two main functions:
1- Displaying the rabbits and foxes for 250 iterations. (after every iteration a board with X’s and O’s, representing foxes and rabbits respectively, is printed with the population counts of the two species)

2- Plotting the predator-prey graph of rabbits and foxes after 250 iterations by using the population number of these species after each iteration.

###Classes
Organism Class: This class is a superclass of foxes and rabbits, defining the common activities of the two species such as every individual’s position on the board.

Rabbit Class: Defines the symbol of rabbits (“O”), breed rate and how each rabbit will move on the board after each iteration

Fox Class: Defines the symbol of foxes (“X”), breed rate and how each fox will move on the board after each iteration

Board Class: Initializes the board by randomly placing each rabbit and fox on a grid, moves each individual after every iteration, performs breeding according to the breed rate, removes rabbits if they are eaten by the foxes and foxes if they are starved.

Simulator Class: Performs 250 iterations of the simulation by carrying out predation and movement of the animals on the board. Prints out the board in every iteration.

Graph Class: Plots the predator-prey graph of rabbits and foxes after the simulation ends.
