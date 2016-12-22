package game;

public class MineSweeper extends Game implements Grid{
	int numOfBombs = 45;
	int curNumOfBombs;
	int xPos, yPos, oldX, oldY, flagCounter;
	boolean firstClick;
	boolean dead;
	public MineSweeper(){
		super(20,20);
		firstClick = false;
		dead = false;
		curNumOfBombs = 0;
		while(curNumOfBombs<numOfBombs){
			xPos = (int)(Math.random()*20);
			yPos = (int)(Math.random()*20);
			if(gameBoard[xPos][yPos] == 'E'){
				gameBoard[xPos][yPos] = 'B';
				curNumOfBombs++;
			}
		}
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				counter =0;
				if(gameBoard[i][j] == 'E'){
					for(int k = 0; k<3; k++){
						for(int a = 0; a<3; a++){
							if(gameBoard[Math.max(i+k-2, 0)][Math.max(j+a-2,0)] == 'B')
								counter++;
						}
					}
					gameBoard[i][j] = (char)(counter + 48);
					if(gameBoard[i][j] == '0')
						gameBoard[i][j] = 'E';
				}
			}
		}
	}
	@Override
	public char[][] getGameBoard() {
		return gameBoard;
	}
	
	public char[][] getPlayerMove(){
		return playerMoves;
	}

	@Override
	public boolean newMove(int x, int y, int playerNum) { //we use playerNum as the type of moves
		char moveType = '0';
		if(playerNum == 0){
			moveType = 'F';
		}
		else{
			moveType = 'O';
		}
		if(gameBoard[x][y] == 'B' && moveType == 'O'){
			dead = true;
			playerMoves[x][y] = 'B';
		}
		updateBoard(x,y,moveType);
		oldX = x; oldY = y;
		return true;
	}
	@Override
	public boolean check(int playerNum) {
		flagCounter = 0;
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				if(playerMoves[i][j]=='E')
					break;
				else if(playerMoves[i][j] == 'F')
					flagCounter++;
			}
		}
		if(flagCounter == numOfBombs)
			return true;
		return false;
	}
	@Override
	public void clearGameBoard() {
		reset();
	}
	@Override
	public void updateBoard(int x, int y, char move) {
		if(move == 'O'){
			playerMoves[x][y] = gameBoard[x][y];
			if((firstClick || distance(x,y,oldX,oldY) > 8) && gameBoard[x][y] == 'E'){
				for(int i = 0; i<7; i++){
					for(int  j = 0; j<7; j++){
						if(gameBoard[Math.max(x+i-4,0)][Math.max(y+j-4,0)] == 'E')
							playerMoves[Math.max(x+i-4,0)][Math.max(y+j-4,0)] = 'O';
						else if(gameBoard[Math.max(x+i-4,0)][Math.max(y+j-4,0)] != 'B')
							playerMoves[Math.max(x+i-4,0)][Math.max(y+j-4,0)] = 'O';
							break;
					}
				}
			}
		}
		else{
			playerMoves[x][y] = 'F';
		}
//		if(move == 'O')
//			playerMoves[x][y] = gameBoard[x][y];
//		else{
//			playerMoves[x][y] = 'F';
//		}
			
	}
}
