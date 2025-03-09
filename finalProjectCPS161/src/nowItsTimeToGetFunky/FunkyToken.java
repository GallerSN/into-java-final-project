package nowItsTimeToGetFunky;

public abstract class FunkyToken {
	public char token;
	public int rowPos;
	public int columnPos;
	public boolean active = true;
	
	public FunkyToken(char c) {
		token = c;
	}
	
	public FunkyToken(char c, boolean a) {// second constructor for non- active tokens on board
		token = c;
		active = a;
	}
	
	public abstract void move(FunkyBoard board);

}
