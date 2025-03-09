package nowItsTimeToGetFunky;

import java.util.Random;

public class MoveOneToken extends FunkyToken{
	public MoveOneToken(char c) {
		super(c);
	}
	
	public MoveOneToken(char c, boolean a) { // second constructor for non- active tokens on board
		super(c,a);
	}

	public void move(FunkyBoard board) {
		int tempRow = rowPos; // saves current position of token for checking
		int tempColumn = columnPos;
		Random rand = new Random();
		boolean moved = false; // boolean for while loop
		int move = rand.nextInt(8); // used to decide a random direction
		FunkyToken temp = new MoveOneToken('-', false);// to replace the old location
		while(!moved) {
			move = rand.nextInt(8);
			switch (move) {
			case 0: // to the left
				board.placeToken(this, this.rowPos, this.columnPos -1);
				break;
			case 1: // take it back now y'all(down)
				board.placeToken(this, tempRow + 1, tempColumn);
				break;

			case 2: // one hop this time(up)
				board.placeToken(this, tempRow - 1, tempColumn);
				break;

			case 3: // slide to the left(down left)
				board.placeToken(this, tempRow + 1, tempColumn -1);
				break;

			case 4: // slide to the right(down right)
				board.placeToken(this, tempRow + 1, tempColumn+1);
				break;

			case 5: // to the right
				board.placeToken(this, tempRow, tempColumn + 1);
				break;

			case 6: //right foot let's stomp(up right)
				board.placeToken(this, tempRow - 1, tempColumn + 1);
				break;
			case 7: //left foot let's stomp(up left)
				board.placeToken(this, tempRow - 1, tempColumn -1);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + move);
			}
			if(this.columnPos != tempColumn || this.rowPos != tempRow) // checks if token moved
				moved = true;
		}
		board.placeToken(temp, tempRow, tempColumn);
	}
	
	

}
