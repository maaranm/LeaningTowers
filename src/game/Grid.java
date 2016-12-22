package game;
//grid interface is implemented by TicTacToe and MineSweeper
public interface Grid {
	public char[][] getGameBoard(); //different types of gameboards will be returned therefore, it should be part of the interface
	
	public void clearGameBoard(); //self explanatory
	
	public boolean newMove(int x, int y, int playerNum); //different types of moves for ticTacToe and Minesweeper
	
	public void updateBoard(int x, int y, char move); //because the gameboards are different, the board must be updated differently
}
