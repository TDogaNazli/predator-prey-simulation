

/**
 * Prints out the habitat of rabbits and foxes
 */
 
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Board {
    
    static Organism[][] field = new Organism[20][20];
    static int numberOfRabbits;
    static int numberOfFoxes;
    Random randomNumGen = new Random();
    
    static int rowScan = 0;
    static int colScan = 0;
    
    /**
     * Constructor.
     */
    public Board()
    {
        numberOfRabbits = 100;
        numberOfFoxes = 5;
        initializeBoard(numberOfRabbits, numberOfFoxes);
        
    }
    
    /**Complete Constructor
     */
    public Board(int rabbits, int foxes)
    {
        numberOfRabbits = rabbits;
        numberOfFoxes = foxes;
        initializeBoard(numberOfRabbits, numberOfFoxes);
        
    }
    
    /**
     * Fills the field randomly with rabbits and .
     */
    public void initializeBoard(int numRabbit, int numFox)
    {       
        for (int i = 0; i < numRabbit; i++)
        {
            place(new Rabbit(), numRabbit);
        }
        
        for (int i = 0; i < numFox; i++)
        {
            place(new Fox(), numFox);
        }
        
    }
    
    /**
     * Check if cell is occupied by any type of Organism
     */
    public boolean isOccupied(int row, int col)
    {   
        if (Board.field[row][col] != null)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    /**
     * Place an Organism in an empty cell
     */
    public void place(Organism o, int numO)
    {
        int row = randomNumGen.nextInt(20);
        int col = randomNumGen.nextInt(20);
        
        while (this.isOccupied(row, col))
        {
            row = randomNumGen.nextInt(20);
            col = randomNumGen.nextInt(20);
        }

        if(o instanceof Rabbit)
        {
            field[row][col] = new Rabbit(row, col);
        }
        
        else if(o instanceof Fox)
        {
            field[row][col]= new Fox(row, col);
        }
        
        else
        {
            System.out.println("Error in placeAnimal method! Did not place a Animal in an open cell.");
            System.exit(0);
        }
    }
    
    public static Organism getAnimal(int row, int col)
    {
        return field[row][col];
    }
    
    public static Organism getAnimal(int[] position)
    {
        return field[position[0]][position[1]];
    }
    

    public boolean rabbitAdjacent(Fox f)
    {
        if (f.topFlag && f.leftFlag)
        {
            if (    (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.bottomFlag && f.rightFlag)
        {
            if (    (getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.topFlag && f.rightFlag)
        {
            if (    (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.bottomFlag && f.leftFlag)
        {
            if (    (getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (f.topFlag)
        {
            if (    (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.rightFlag)
        {
            if (    (getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.bottomFlag)
        {
            if (    (getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (f.leftFlag)
        {
            if (    (getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) ||
                    (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if ((getAnimal(f.getRowPosition() - 1, f.getColPosition()) instanceof Rabbit) ||
                (getAnimal(f.getRowPosition(), f.getColPosition() + 1) instanceof Rabbit) ||
                (getAnimal(f.getRowPosition() + 1, f.getColPosition()) instanceof Rabbit) ||
                (getAnimal(f.getRowPosition(), f.getColPosition() - 1) instanceof Rabbit) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean emptyCellAdjacent(Organism Animal)
    {
        if (Animal.topFlag && Animal.leftFlag)
        {
            if (    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) ||
                    (getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (Animal.bottomFlag && Animal.rightFlag)
        {
            if ((getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (Animal.topFlag && Animal.rightFlag)
        {
            if ((getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) ||
                (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (Animal.bottomFlag && Animal.leftFlag)
        {
            if ((getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (Animal.topFlag)
        {
            if (
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) ||
                    (getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (Animal.rightFlag)
        {
            if (
                    (getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        else if (Animal.bottomFlag)
        {
            if (
                    (getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (Animal.leftFlag)
        {
            if (
                    (getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                    (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) ||
                    (getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) )
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        else if (
                (getAnimal(Animal.getRowPosition() - 1, Animal.getColPosition()) == null) ||
                (getAnimal(Animal.getRowPosition(), Animal.getColPosition() + 1) == null) ||
                (getAnimal(Animal.getRowPosition() + 1, Animal.getColPosition()) == null) ||
                (getAnimal(Animal.getRowPosition(), Animal.getColPosition() - 1) == null) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Print out the board
     */
    public void printBoard()
    {       
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        
        for(int i = 0; i < field.length; i++)
        {
            System.out.printf("%2d|", i);
            
            for(int j = 0; j < field[i].length; j++)
            {
                if (field[i][j] == null)
                {
                    System.out.print("-");
                }
                
                else
                {
                        System.out.print(field[i][j].symbol);
                
                }
            }

            System.out.print("|");
            
            if (i < field.length - 1)
            {
                System.out.println();
            }
        }
        
        System.out.println("\n");
        System.out.println("Number of Rabbits: " + numberOfRabbits);
        System.out.println("Number of Foxes: " + numberOfFoxes);

    }
    
    public void removeAnimal(int row, int col)
    {
        if (field[row][col] == null)
        {
            System.out.println("Error: removeAnimal tried to remove a Animal, but there was none.");
            System.exit(0);
        }
        
        if(field[row][col] instanceof Rabbit)
        {
            numberOfRabbits--;
        }
        
        if(field[row][col] instanceof Fox)
        {
            numberOfFoxes--;
        }
        
        field[row][col] = null;
    }
    
    public static Integer[] randomDirections()
    {
        Integer[] directionArray = new Integer[] {1, 2, 3, 4};
        
        Collections.shuffle(Arrays.asList(directionArray));
        
        return directionArray;
    }
    
    public int getRabbitNumber(){
        return numberOfRabbits;
    }
    
    public int getFoxNumber(){
        return numberOfFoxes;
    }
    
    public static int[] rabbitScanner()
    {
        for (int j = colScan; j < 20; j++)
        {
            if (field[rowScan][j] instanceof Rabbit)
            {
                if (colScan >= 19)
                {
                    colScan = 0;
                    rowScan++;
                    return new int[] {rowScan - 1, 19};
                }
                
                else
                {
                    colScan = j + 1;
                    return new int[] {rowScan, j};
                }
            }
        }
        
        rowScan++;
        colScan = 0;
        
        for (int i = rowScan; i < 20; i++)
        {
            for (int j = colScan; j < 20; j++)
            {
                if (field[i][j] instanceof Rabbit)
                {
                    if (j >= 19)
                    {
                        colScan = 0;
                        rowScan++;
                        return new int[] {i, 19};
                    }
                    else
                    {
                        colScan = j + 1;
                        return new int[] {i, j};
                    }
                    
                }
                
                else if (j >= 19)
                {
                    colScan = 0;
                    rowScan++;
                }
            }
        }
        
        rowScan = 0;
        colScan = 0;
        return new int[] {-1, -1};
    }
    
   
    public static int[] foxScanner()
    {
        for (int j = colScan; j < 20; j++)
        {
            if (field[rowScan][j] instanceof Fox)
            {
                if (colScan >= 19)
                {
                    colScan = 0;
                    rowScan++;
                    return new int[] {rowScan - 1, 19};
                }
                else
                {
                    colScan = j + 1;
                    return new int[] {rowScan, j};
                }
            }
        }
        
        rowScan++;
        colScan = 0;
        
        for (int i = rowScan; i < 20; i++)
        {
            for (int j = colScan; j < 20; j++)
            {
                if (field[i][j] instanceof Fox)
                {
                    if (j >= 19)
                    {
                        colScan = 0;
                        rowScan++;
                        return new int[] {i, 19};
                    }
                    
                    else
                    {
                        colScan = j + 1;
                        return new int[] {i, j};
                    }
                }
            }
            
            colScan = 0;
            rowScan++;
        }
        
        rowScan = 0;
        colScan = 0;
        return new int[] {-1, -1};
    }
    
    public static void moveAnimal(Organism Animal, int direction)
    {
        int rowPos = Animal.getRowPosition();
        int colPos = Animal.getColPosition();
        
        if (Animal.getSymbol() == 'O')
        {
            switch (direction)
            {
            case 1:
                field[rowPos - 1][colPos] = new Rabbit((Rabbit) Animal);
                getAnimal(rowPos - 1, colPos).setRowPosition(rowPos - 1);
                field[rowPos][colPos] = null;
                rowPos--;
                break;
            case 2:
                field[rowPos][colPos + 1] = new Rabbit((Rabbit) Animal);
                getAnimal(rowPos, colPos + 1).setColPosition(colPos + 1);
                field[rowPos][colPos] = null;
                colPos++;
                break;
            case 3:
                field[rowPos + 1][colPos] = new Rabbit((Rabbit) Animal);
                getAnimal(rowPos + 1, colPos).setRowPosition(rowPos + 1);
                field[rowPos][colPos] = null;
                rowPos++;
                break;
            case 4:
                field[rowPos][colPos - 1] = new Rabbit((Rabbit) Animal);
                getAnimal(rowPos, colPos - 1).setColPosition(colPos - 1);
                field[rowPos][colPos] = null;
                colPos--;
                break;
            }
        }
        
        else if(Animal.getSymbol() == 'X')
        {
            switch (direction)
            {
            case 1:
                field[rowPos - 1][colPos] = new Fox((Fox) Animal);
                getAnimal(rowPos - 1, colPos).setRowPosition(rowPos - 1);
                field[rowPos][colPos] = null;
                rowPos--;
                break;
            case 2:
                field[rowPos][colPos + 1] = new Fox((Fox) Animal);
                getAnimal(rowPos, colPos + 1).setColPosition(colPos + 1);
                field[rowPos][colPos] = null;
                colPos++;
                break;
            case 3:
                field[rowPos + 1][colPos] = new Fox((Fox) Animal);
                getAnimal(rowPos + 1, colPos).setRowPosition(rowPos + 1);
                field[rowPos][colPos] = null;
                rowPos++;
                break;
            case 4:
                field[rowPos][colPos - 1] = new Fox((Fox) Animal);
                getAnimal(rowPos, colPos - 1).setColPosition(colPos - 1);
                field[rowPos][colPos] = null;
                colPos--;
                break;
            }
            
            Animal.timeSinceBreed++;
        }
    }
    
    /**
     * Creates a new Animal of the same type in an adjacent cell.
     */
    public void breed(Organism Animal)
    {
        if ((Animal.timeSinceBreed == Animal.breedTime) && this.emptyCellAdjacent(Animal))
        {
            int row = Animal.getRowPosition();
            int col = Animal.getColPosition();
            
            Integer[] randomDirections = Board.randomDirections();
            boolean breedComplete = false;
            
            if (Animal instanceof Rabbit)
            {
                Rabbit rabbit = (Rabbit) Board.getAnimal(row, col);
                
                for (int i = 0; i < 4 && (breedComplete == false); i++)
                {
                    switch (randomDirections[i])
                    {
                    case 1:
                        if (rabbit.topFlag)
                            break;
                        
                        if (Board.getAnimal(row - 1, col) == null)
                        {
                            field[row - 1][col] = new Rabbit(row - 1, col);
                            breedComplete = true;
                        }
                        break;
                    case 2:
                        if (rabbit.rightFlag)
                            break;
                        
                        if (Board.getAnimal(row, col + 1) == null)
                        {
                            field[row][col + 1] = new Rabbit(row, col + 1);
                            breedComplete = true;
                        }
                        break;
                    case 3:
                        if (rabbit.bottomFlag)
                            break;
                        
                        if (Board.getAnimal(row + 1, col) == null)
                        {
                            field[row + 1][col] = new Rabbit(row + 1, col);
                            breedComplete = true;
                        }
                        break;
                    case 4:
                        if (rabbit.leftFlag)
                            break;
                        
                        if (Board.getAnimal(row, col - 1) == null)
                        {
                            field[row][col - 1] = new Rabbit(row, col - 1);
                            breedComplete = true;
                        }
                        break;
                    }
                }
                Animal.timeSinceBreed = 0; 
                numberOfRabbits++;
            }
            else if (Animal instanceof Fox)
            {
                Fox f = (Fox) Board.getAnimal(row, col);
                
                for (int i = 0; i < 4 && (breedComplete == false); i++)
                {
                    switch (randomDirections[i])
                    {
                    case 1:
                        if (f.topFlag)
                            break;
                        
                        if (Board.getAnimal(row - 1, col) == null)
                        {
                            field[row - 1][col] = new Fox(row - 1, col);
                            breedComplete = true;
                        }
                        break;
                    case 2:
                        if (f.rightFlag)
                            break;
                        
                        if (Board.getAnimal(row, col + 1) == null)
                        {
                            field[row][col + 1] = new Fox(row, col + 1);
                            breedComplete = true;
                        }
                        break;
                    case 3:
                        if (f.bottomFlag)
                            break;
                        
                        if (Board.getAnimal(row + 1, col) == null)
                        {
                            field[row + 1][col] = new Fox(row + 1, col);
                            breedComplete = true;
                        }
                        break;
                    case 4:
                        if (f.leftFlag)
                            break;
                        
                        if (Board.getAnimal(row, col - 1) == null)
                        {
                            field[row][col - 1] = new Fox(row, col - 1);
                            breedComplete = true;
                        }
                        break;
                    }
                }
                Animal.timeSinceBreed = 0;
                numberOfFoxes++;
            }
            else 
            {
                System.out.println("Error in breed!");
                System.exit(0);
            }
        }       
    }
    
    /**
     * Check if the given fox hasn't eaten
     */
    public void starve(Fox f)
    {
        if (f.timeSinceEat >= Fox.STARVE_THRESHOLD)
        {
            this.removeAnimal(f.getRowPosition(), f.getColPosition());
        }
    }
}