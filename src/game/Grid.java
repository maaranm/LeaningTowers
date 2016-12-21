package game;

public interface Grid {
	public char[][] getGameBoard();
	
	public void clearGameBoard();
	
	public boolean newMove(int x, int y, int playerNum);
}
