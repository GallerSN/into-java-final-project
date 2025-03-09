package nowItsTimeToGetFunky;

public class FunkyBoard {
	private FunkyToken[][] board;
	public int size;
	public char emptySpace = '-';
	
	public FunkyBoard(int s) {
			size  = s;
			board = new FunkyToken[s][s];
			for (int i = 0; i < size; i++) { // initialize array
				for (int j = 0; j < size; j++) {
					board[i][j] = new MoveOneToken(emptySpace, false);
				}
			}
	
	}
	
	public void displayBoard()	{
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print("|" + board[i][j].token);
			}
			System.out.println("|");
		}
	}
	
	public void placeToken(FunkyToken token, int row, int column) {
		if(!canPlace(row, column))
			return;
		
		// make token inactive if landed on
		if (board[column][row].active == true && token.active != false)
			board[column][row].active = false;
		
		board[column][row] = token; // moves token
		token.rowPos = row;
		token.columnPos = column;
		
	}
	
	public boolean canPlace(int row, int column) { // checks if new location is valid
		if(row >= size || column >= size)
			return false;
		else if(row < 0 || column < 0)
			return false;
		// I know it's inefficient but it's easier for me to read
		return true;
	}
	
	public FunkyToken getWinner() {
		int wRow = 0; //location of winning token
		int wColumn = 0;
		int activeCount = 0; // counter for active tokens
		FunkyToken winner;
		
		for (int column = 0; column < size; column++) {
			for (int row = 0; row < size; row++) {
				if(board[column][row].active == true) { //checks if token is still active
					wRow = row;
					wColumn = column;
					activeCount++;
				}
			}
		}
		if(activeCount == 1) // only returns a winner if there's exactly one active token
			winner = board[wColumn][wRow];
		else
			winner = null;
		
		return winner;
	}

}
