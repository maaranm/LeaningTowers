package game;

public class MineSweeper extends Game implements Grid{
	int numOfBombs = 10;
	int curNumOfBombs;
	int xPos, yPos;
	public MineSweeper(){
		super(20,20);
		curNumOfBombs = 0;
		while(curNumOfBombs<numOfBombs){
			xPos = (int)(Math.random()*10);
			yPos = (int)(Math.random()*10);
			if(gameBoard[xPos][yPos] == 'e'){
				gameBoard[xPos][yPos] = 'b';
				curNumOfBombs++;
			}
		}
		playerMoves = gameBoard;
	}
	@Override
	public char[][] getGameBoard() {
		return gameBoard;
	}

	@Override
	public boolean newMove(int x, int y, int playerNum) { //we use playerNum as the type of moves
		char moveType = '0';
		if(!(checkValid(x, y, this.gameBoard)))
			return false;
		if(playerNum == 0){
			moveType = 'f';
		}
		else{
			moveType = 'o';
		}
		playerMoves[x][y] = moveType;
		return true;
		
	}
	@Override
	public boolean check(int playerNum) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clearGameBoard() {
		reset();
	}
	
}
