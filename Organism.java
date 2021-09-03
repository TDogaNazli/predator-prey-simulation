/**
 * The organism superclass
 */
 
public class Organism
{
	int breedTime; //At what time the organism breeds
	int timeSinceBreed;
	char symbol; //O for Rabbits, X for Foxes
	int rowPosition;
	int colPosition;
	
	//Flags for edges of the board
	boolean topFlag;
	boolean rightFlag;
	boolean bottomFlag;
	boolean leftFlag;
	
	/**
	* Constructor
	*/
	public Organism()
	{
		this.setRowPosition(-1);
		this.setColPosition(-1);
		this.timeSinceBreed = 0;
		this.topFlag = true;
		this.bottomFlag = true;
		this.leftFlag = true;
		this.rightFlag = true;
		
	}
	
	/**
	* Constructor
	* @param row The row position of the organism 
	* @param col The column position of the organism
	*/
	public Organism(int row, int col)
	{
		this.setRowPosition(row);
		this.setColPosition(col);
		this.timeSinceBreed = 0;
	}
	
	/**
	* Constructor
	* @param o organism to be copied
	*/
	public Organism(Organism o)
	{
		this.breedTime = o.breedTime;
		this.timeSinceBreed = o.timeSinceBreed;
		this.symbol = o.symbol;
		this.setRowPosition(o.getRowPosition());
		this.setColPosition(o.getColPosition());
	}
	
	/**
	* @return symbol
	*/
	public char getSymbol()
	{
		return this.symbol;
	}
	
	/**
	* @return row position
	*/
	public int getRowPosition()
	{
		return this.rowPosition;
	}
	
	/**
	* @return column position
	*/
	public int getColPosition()
	{
		return this.colPosition;
	}
	
	/**
	* Sets flags to the edges of the board.
	* @param row New row position
	*/
	public void setRowPosition(int row)
	{
		this.topFlag = false;
		this.bottomFlag = false;
		
		this.rowPosition = row;
		
		if (row <= 0)
		{
			this.topFlag = true;
		}
		
		else if(row >= 19)
		{
			this.bottomFlag = true;
		}
	}
	
	/**
	* Sets flags to the edges of the board.
	* @param col New column position
	*/
	public void setColPosition(int col)
	{
		this.leftFlag = false;
		this.rightFlag = false;
		
		this.colPosition = col;
		
		if (col <= 0)
		{
			this.leftFlag = true;
		}
		
		else if(col >= 19)
		{
			this.rightFlag = true;
		}
	}
}