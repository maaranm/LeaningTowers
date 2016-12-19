package game;

public interface Grid {
	public char[][] getGameBoard();
	
	public boolean newMove(int x, int y, int playerNum);
	
	public boolean check(int playerNum);
	
}
