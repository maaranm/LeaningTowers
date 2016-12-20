package game;

public class MineSweeper implements Grid{
	char[][] gameBoard = new char[20][20];
	char[][] playerMoves;
	int numOfBombs = 10;
	int curNumOfBombs;
	int xPos, yPos;
	public MineSweeper(){
		curNumOfBombs = 0;
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				gameBoard[i][j] = 'e';
			}
		}
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
		if(!((x >= 0 && x < 10) && (y >= 0 && y < 10)))
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
	
}
