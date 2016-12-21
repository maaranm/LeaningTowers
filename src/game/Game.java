package game;

public abstract class Game {
	char[][] gameBoard;
	char[][] playerMoves;
	int xSize, ySize;
	int counter;
	public Game(int x, int y){
		counter = 0;
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
	
	public int Distance(int xOne, int yOne, int xTwo, int yTwo){
		int distance = (int) Math.sqrt(Math.pow(xOne-xTwo, 2)+Math.pow(yOne-yTwo, 2));
		return distance;
	}
}
