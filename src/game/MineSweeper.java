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
			if(gameBoard[xPos][yPos] == 'E'){
				gameBoard[xPos][yPos] = 'B';
				curNumOfBombs++;
			}
		}
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				if(gameBoard[i][j] == 'E'){
					for(int k = 0; k<3; k++){
						for(int a = 0; a<3; a++){
							if(gameBoard[i+k-2][i+a-2] == 'B')
								counter++;
								
						}
					}
				}
				gameBoard[i][j] = (char)(counter + 48);
				if(gameBoard[i][j] == '0')
					gameBoard[i][j] = 'E';
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
			moveType = 'F';
		}
		else{
			moveType = 'O';
		}
		updateBoard(x,y,moveType);
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
	@Override
	public void updateBoard(int x, int y, char move) {
		int xCounter = 0;
		int yCounter = 0;
		while(true){
			if(gameBoard[x+xCounter][y] == 'E')
			{
				
			}
				
		}
	}
	
}
