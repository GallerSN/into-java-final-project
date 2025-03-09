package nowItsTimeToGetFunky;

import java.util.Random;

public class RandomToken extends FunkyToken {
	
	public RandomToken(char c) {
		super(c);
	}

	public void move(FunkyBoard board) {
		int rMove;
		int cMove; // used for random coordinate
		int tempRow = rowPos; // saves current position
		int tempColumn = columnPos;
		boolean moved = false;
		FunkyToken temp = new MoveOneToken('-', false);
		Random rand = new Random(); // to empty previous location
		
		while(moved == false) {
			rMove = rand.nextInt(7); // this generates a random coordinate to move the token to
			cMove = rand.nextInt(7);
			
			//check to make sure the token does not capture itself
			if(rMove != this.rowPos && cMove != this.columnPos) {
				board.placeToken(this, rMove, cMove);
				moved = true;
			}
		}
		board.placeToken(temp, tempRow, tempColumn);
	}
	
	

}
