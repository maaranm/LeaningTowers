package game;

public abstract class Game {
	char[][] gameBoard;
	char[][] playerMoves;
	int xSize, ySize;
	public Game(int x, int y){
		xSize = x; ySize = y;
		gameBoard = new char[x][y];
		for(int i = 0; i<x; i++){
			for(int j = 0; j<y; j++){
				gameBoard[i][j] = 'E';
			}
		}
	}
	
	public abstract boolean check(int playerNum);
	
	public boolean checkValid(int x, int y, char[][] pastMoves){
		if((x>=0 && x<xSize)&&(y>=0 && y<ySize)&&(pastMoves[x][y] == 'E'))
			return true;
		else
			return false;
	}
	
	public void reset(){
		for(int i = 0; i<xSize; i++){
			for(int j = 0; j<ySize; j++){
				gameBoard[i][j] = 'E';
			}
		}
		playerMoves = gameBoard;
	}
}
