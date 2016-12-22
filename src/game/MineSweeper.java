package game;

public class MineSweeper extends Game implements Grid{
	//declare majority of the variables which will be used class wide
	int numOfBombs = 45;
	int curNumOfBombs;
	int xPos, yPos, oldX, oldY, flagCounter;
	boolean firstClick;
	boolean dead;
	//constructor takes no arguments
	public MineSweeper(){
		super(20,20); //calls super constructor in Game class and gives x and y values of 20
		firstClick = false; //used to determine how many tiles to unveil
		dead = false; //if a bomb is clicked it will change to true
		curNumOfBombs = 0;
		//randomly chooses points on the board to assign as bombs
		//keeps looping until there is the chosen # of bombs
		while(curNumOfBombs<numOfBombs){
			xPos = (int)(Math.random()*20);
			yPos = (int)(Math.random()*20);
			if(gameBoard[xPos][yPos] == 'E'){
				gameBoard[xPos][yPos] = 'B';
				curNumOfBombs++;
			}
		}
		//Used to assign number values to the tiles
		//Indexes through each index and then checks all the tiles surrounding it
		for(int i = 0; i<20; i++){
			for(int j = 0; j<20; j++){
				counter =0;
				if(gameBoard[i][j] == 'E'){
					for(int k = 0; k<3; k++){
						for(int a = 0; a<3; a++){
							if(gameBoard[Math.max(i+k-2, 0)][Math.max(j+a-2,0)] == 'B') //for every bomb increase the counter value by 1
								counter++;
						}
					}
					gameBoard[i][j] = (char)(counter + 48); //convert the int to the char equivalent of an int
					if(gameBoard[i][j] == '0') //if it's zero just set it to E
						gameBoard[i][j] = 'E';
				}
			}
		}
	}
	@Override
	public char[][] getGameBoard() { //returns gameBoard array
		return gameBoard;
	}
	
	public char[][] getPlayerMove(){ //returns playerMoves array
		return playerMoves;
	}

	@Override
	public boolean newMove(int x, int y, int playerNum) { //we use playerNum as the type of moves
		char moveType = '0';
		//convert player num into a movetype 
		if(playerNum == 0){
			moveType = 'F';
		}
		else{
			moveType = 'O';
		}
		//checks if the tile that was chosen is a bomb
		if(gameBoard[x][y] == 'B' && moveType == 'O'){
			dead = true;
			playerMoves[x][y] = 'B';
		}
		//use update board to determine what to do with the players move
		updateBoard(x,y,moveType);
		//keeps track of previous user move
		oldX = x; oldY = y;
		return true;
	}
	@Override
	public boolean check(int playerNum) { //checks if the player has won
		flagCounter = 0;
		//indexes through the 2D array
		for(int i = 0; i<20; i++){ 
			for(int j = 0; j<20; j++){
//				if(playerMoves[i][j]=='E') //if there are 
//					break;
				if(playerMoves[i][j] == 'F') //count the number of flags to check if the exact number of bombs have been flagged
					flagCounter++;
			}
		}
		if(flagCounter == numOfBombs)
			return true;
		return false;
	}
	@Override
	public void clearGameBoard() { //clear the gameboard
		reset();
	}
	@Override
	public void updateBoard(int x, int y, char move) {//determines what kind of move to make
		if(move == 'O'){ //if the player wants to open a tile
			playerMoves[x][y] = gameBoard[x][y]; //set that tile to the gameBoard equivalent
			if((firstClick || distance(x,y,oldX,oldY) > 8) && gameBoard[x][y] == 'E'){ //checks if the tile is in a new "Zone"
				//indexes through the array
				for(int i = 0; i<7; i++){
					for(int  j = 0; j<7; j++){
						if(gameBoard[Math.max(x+i-4,0)][Math.max(y+j-4,0)] == 'E') //checks if the tile is empty
							playerMoves[Math.max(x+i-4,0)][Math.max(y+j-4,0)] = 'O'; //sets the player array to open
						else if(gameBoard[Math.max(x+i-4,0)][Math.max(y+j-4,0)] != 'B')
							playerMoves[Math.max(x+i-4,0)][Math.max(y+j-4,0)] = gameBoard[Math.max(x+i-4,0)][Math.max(y+j-4,0)];
							break;
					}
				}
			}
		}
		else{ //just for flagging the playerMoves
			playerMoves[x][y] = 'F';
		}
//		if(move == 'O')
//			playerMoves[x][y] = gameBoard[x][y];
//		else{
//			playerMoves[x][y] = 'F';
//		}
			
	}
}
