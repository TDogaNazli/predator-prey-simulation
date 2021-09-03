

/**
 * Fox subclass
 */
 
public class Fox extends Organism
{
	final static int STARVE_THRESHOLD = 3;
	int timeSinceEat;
	
	/**
	* Constructor
	*/
	public Fox()
	{
		super();
		this.symbol = 'X';
		this.breedTime = 8;
		this.timeSinceEat = 0;
	}
	
	/**
	* Constructor.
	* @param row Row position of a fox
	* @param col Column position of a fox
	*/
	public Fox(int row, int col)
	{
		super(row, col);
		this.symbol = 'X';
		this.breedTime = 8;
		this.timeSinceEat = 0;
	}
	
	/**
	* Constructor
	* @param d
	*/
	public Fox(Fox f)
	{
		super(f);
		this.symbol = f.symbol;
		this.breedTime = f.breedTime;
		this.timeSinceEat = f.timeSinceEat;
	}
	
	/**
	* Takes 1, 2, 3, or 4, and moves fox up, right, down, or left accordingly.
	* @param direction The direction to move the fox.
	*/
	public void moveFox(int direction)
	{
		if (direction < 1 || direction > 4)
		{
			System.out.println("Error: Improper parameter.");
			System.exit(0);
		}
		
		switch (direction) {
			case 1: Board.field[this.getRowPosition() - 1][this.getColPosition()] = null; 
					Board.field[this.getRowPosition() - 1][this.getColPosition()] = this; 
					Board.field[this.getRowPosition()][this.getColPosition()] = null; 
					this.setRowPosition(this.getRowPosition() - 1);
					break;
					
			case 2: Board.field[this.getRowPosition()][this.getColPosition() + 1] = null; 
					Board.field[this.getRowPosition()][this.getColPosition() + 1] = this; 
					Board.field[this.getRowPosition()][this.getColPosition()] = null; 
					this.setColPosition(this.getColPosition() + 1);
					break;
					
			case 3: Board.field[this.getRowPosition() + 1][this.getColPosition()] = null; 
					Board.field[this.getRowPosition() + 1][this.getColPosition()] = this; 
					Board.field[this.getRowPosition()][this.getColPosition()] = null; 
					this.setRowPosition(this.getRowPosition() + 1);
					break;
					
			case 4: Board.field[this.getRowPosition()][this.getColPosition() - 1] = null; 
					Board.field[this.getRowPosition()][this.getColPosition() - 1] = this;
					Board.field[this.getRowPosition()][this.getColPosition()] = null; 
					this.setColPosition(this.getColPosition() - 1);
					break;
		}
	}

}