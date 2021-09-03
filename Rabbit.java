
/*
 * Rabbit subclass
 */

public class Rabbit extends Organism
{
	/**
	* Constructor
	* Sets symbol to 'O' and breedTime to 3.
	*/
	public Rabbit()
	{
		super();
		this.symbol = 'O';
		this.breedTime = 3;
	}
	
	/**
	* Constructor.
	* Places rabbit at given row and col, sets symbol to 'O'
	* and breedTime to 3.
	* @param row The row position of the rabbit.
	* @param col The column position of the rabbit.
	*/
	public Rabbit(int row, int col)
	{
		super(row, col);
		this.symbol = 'O';
		this.breedTime = 3;
	}
	
	/**
	* Constructor
	* @param f
	*/
	public Rabbit(Rabbit f)
	{
		super(f);
	}
	
	/**
	* Moves the rabbit in the given direction.
	* @param direction The direction for the rabbit to be moved.
	*/
	public void moveRabbit(int direction)
	{
		if (direction < 1 || direction > 4)
		{
			System.err.println("Error: Improper parameter.");
			System.exit(0);
		}
		
		switch (direction) {
		case 1: 
				Board.field[this.getRowPosition() - 1][this.getColPosition()] = this; 
				Board.field[this.getRowPosition()][this.getColPosition()] = null; 
				this.setRowPosition(this.getRowPosition() - 1);
				break;
				
		case 2: 
				Board.field[this.getRowPosition()][this.getColPosition() + 1] = this; 
				Board.field[this.getRowPosition()][this.getColPosition()] = null; 
				this.setColPosition(this.getColPosition() + 1);
				break;
				
		case 3: 
				Board.field[this.getRowPosition() + 1][this.getColPosition()] = this; 
				Board.field[this.getRowPosition()][this.getColPosition()] = null;
				this.setRowPosition(this.getRowPosition() + 1);
				break;
				
		case 4: 
				Board.field[this.getRowPosition()][this.getColPosition() - 1] = this; 
				Board.field[this.getRowPosition()][this.getColPosition()] = null; 
				this.setColPosition(this.getColPosition() - 1);
				break;
	}
		
	}
}