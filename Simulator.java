import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Scanner;

public class Simulator {
    
    static ArrayList<Integer> rabbitCount = new ArrayList<Integer>();
    static ArrayList<Integer> foxCount = new ArrayList<Integer>();
    
    /**
     * A fox eats an adjacent rabbit
     */
    public static void eatRabbit(int[] coordinates)
    {

        Fox f = (Fox) Board.getAnimal(coordinates[0], coordinates[1]);
        
        Integer[] randomDirections = Board.randomDirections();
        
        boolean moveComplete = false;
        
        for (int i = 0; i < 4 && (moveComplete == false); i++)
        {
            switch (randomDirections[i])
            {
            case 1:
                if (f.topFlag)
                    break;

                if (Board.getAnimal(coordinates[0] - 1, coordinates[1]) instanceof Rabbit)
                {
                    Board.field[coordinates[0] - 1][coordinates[1]] = null;
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 1);
                    moveComplete = true;
                    Board.numberOfRabbits--;
                }
                break;
            case 2:
                if (f.rightFlag)
                    break;

                if (Board.getAnimal(coordinates[0], coordinates[1] + 1) instanceof Rabbit)
                {
                    Board.field[coordinates[0]][coordinates[1] + 1] = null;
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 2);
                    moveComplete = true;
                    Board.numberOfRabbits--;
                }
                break;
            case 3:
                if (f.bottomFlag)
                    break;

                if (Board.getAnimal(coordinates[0] + 1, coordinates[1]) instanceof Rabbit)
                {
                    Board.field[coordinates[0] + 1][coordinates[1]] = null;
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 3);
                    moveComplete = true;
                    Board.numberOfRabbits--;
                }
                break;
            case 4:
                if (f.leftFlag)
                    break;

                if (Board.getAnimal(coordinates[0], coordinates[1] - 1) instanceof Rabbit)
                {
                    Board.field[coordinates[0]][coordinates[1] - 1] = null;
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 4);
                    moveComplete = true;
                    Board.numberOfRabbits--;
                }
                break;
            }
        }
        
    }
    
    public static void moveFox(int[] coordinates)
    {
        int row = coordinates[0];
        int col = coordinates[1];
        Fox f = (Fox) Board.getAnimal(row, col);
        
        Integer[] randomDirections = Board.randomDirections();
        boolean moveComplete = false;
        for (int i = 0; i < 4 && (moveComplete == false); i++)
        {
            switch (randomDirections[i])
            {
            case 1:
                if (f.topFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0] - 1, coordinates[1]) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 1);
                    moveComplete = true;
                }
                break;
            case 2:
                if (f.rightFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0], coordinates[1] + 1) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 2);
                    moveComplete = true;
                }
                break;
            case 3:
                if (f.bottomFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0] + 1, coordinates[1]) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 3);
                    moveComplete = true;
                }
                break;
            case 4:
                if (f.leftFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0], coordinates[1] - 1) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 4);
                    moveComplete = true;
                }
                break;
            }
        }
    }
    
    public static void moveRabbit(int[] coordinates)
    {
        int row = coordinates[0];
        int col = coordinates[1];

        Rabbit Rabbit = (Rabbit) Board.getAnimal(row, col);
        
        Integer[] randomDirections = Board.randomDirections();
        boolean moveComplete = false;
        
        for (int i = 0; i < 4 && (moveComplete == false); i++)
        {
            switch (randomDirections[i])
            {
            case 1:
                if (Rabbit.topFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0] - 1, coordinates[1]) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 1);
                    moveComplete = true;
                }
                break;
            case 2:
                if (Rabbit.rightFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0], coordinates[1] + 1) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 2);
                    moveComplete = true;
                }
                break;
            case 3:
                if (Rabbit.bottomFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0] + 1, coordinates[1]) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 3);
                    moveComplete = true;
                }
                break;
            case 4:
                if (Rabbit.leftFlag)
                    break;
                
                if (Board.getAnimal(coordinates[0], coordinates[1] - 1) == null)
                {
                    Board.moveAnimal(Board.getAnimal(coordinates[0], coordinates[1]), 4);
                    moveComplete = true;
                }
                break;
            }
        }
    }
    
    public static int[][] RabbitPositions()
    {
        int[][] positions = new int[Board.numberOfRabbits][2];
        
        for (int i = 0; i < Board.numberOfRabbits; i++)
        {
            positions[i] = Board.rabbitScanner();
        }
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }
    
    public static int[][] FoxPositions()
    {
        int[][] positions = new int[Board.numberOfFoxes][2];
        
        for (int i = 0; i < Board.numberOfFoxes; i++)
        {
            positions[i] = Board.foxScanner();
        }
        Board.rowScan = 0;
        Board.colScan = 0;
        return positions;
    }
    
    /**
     * Performs one sequence of events
     */
    public static void turnSequence(Board testBoard)
    {
        int[][] fPositions = new int[Board.numberOfFoxes][2];
        fPositions = FoxPositions();
        int[] position = new int[2];
        
        for (int i = 0; i < Board.numberOfFoxes; i++)
        {
            position = fPositions[i];           
            
            if (position[0] < 0 || position[1] < 0)
            {
                System.out.println("-1 from FoxScanner");
                System.exit(0);
            }
            else if (position[0] > 19 || position[1] > 19)
            {
                System.out.println("20 from FoxScanner");
                System.exit(0);
            }
            
            if (testBoard.rabbitAdjacent((Fox)Board.getAnimal(position)))
            {
                Fox f = (Fox)Board.getAnimal(position);
                f.timeSinceEat = 0;
                f.timeSinceBreed++;
                eatRabbit(position);
                
            }
            else
            {
                Fox f = (Fox)Board.getAnimal(position);
                f.timeSinceEat++;
                f.timeSinceBreed++;
                moveFox(position);
            }   
        }
        
        int[][] RabbitPositions = new int[Board.numberOfRabbits][2];
        RabbitPositions = RabbitPositions();
        
        for (int i = 0; i < Board.numberOfRabbits; i++)
        {
            position = RabbitPositions[i];
            
            if (position[0] < 0 || position[1] < 0)
            {
                break;
            }
            
            Rabbit Rabbit = (Rabbit)Board.getAnimal(position);
            Rabbit.timeSinceBreed++;
            moveRabbit(position);
        }
        
        Board.rowScan = 0;
        Board.colScan = 0;
        
        fPositions = FoxPositions();
        int tempNumberOfFoxs = Board.numberOfFoxes;
        for (int i = 0; i < tempNumberOfFoxs; i++)
        {
            position = fPositions[i];
            int row = position[0];
            int col = position[1];
            
            if (row < 0 || col < 0)
            {
                break;
            }
            
            testBoard.breed(Board.getAnimal(position));
        }
        
        RabbitPositions = RabbitPositions();
        int tempNumberOfRabbits = Board.numberOfRabbits;
        
        for (int i = 0; i < tempNumberOfRabbits; i++)
        {   
            position = RabbitPositions[i];
            int row = position[0];
            int col = position[1];
            
            if (row < 0 || col < 0)
            {
                break;
            }
            
            testBoard.breed(Board.getAnimal(row, col));
        }
        
        fPositions = FoxPositions();
        tempNumberOfFoxs = Board.numberOfFoxes;
        
        for (int i = 0; i < tempNumberOfFoxs; i++)
        {
            testBoard.starve((Fox)Board.getAnimal(fPositions[i][0], fPositions[i][1]));
        }
        
    }
    
    /**
     * Creates the predator-prey model for simulation
     */
    public static void main(String[] args)
    {
        Board testBoard = new Board();
        testBoard.printBoard();
        
        int i = 0;
        while ((Board.numberOfRabbits != 0 || Board.numberOfFoxes != 0) && i < 250)
        {
            rabbitCount.add(testBoard.numberOfRabbits);
            foxCount.add(testBoard.numberOfFoxes);
            
            turnSequence(testBoard);
            
            testBoard.printBoard();
            
            i++;
        }
        
        
        Graph g = new Graph(rabbitCount, foxCount);
        JFrame frame = new JFrame();
        frame.add(g);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setVisible(true);
    }
   
}