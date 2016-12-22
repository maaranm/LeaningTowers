package game;

public class TicTacToe extends Game implements Grid{
	boolean twoPlayer;
	boolean cpuMove;
	int moveCounter;
	public TicTacToe(boolean twoPlayer){ //either two player or one player
		super(3,3); //calls super constructor with parameters 3,3
		moveCounter = 0;
		cpuMove = false;
		this.twoPlayer = twoPlayer; //sets twoPlayer to constructer input
	}
	
	public boolean isPlayerOne(){ //checks if it is playerOne depending on the round num
		if(twoPlayer){
			if((moveCounter%2) != 0)
				return true;
			else
				return false;
		}
		else{ //for one player games
			if(cpuMove)
				return false;
			else
				return true;
		}
	}
	
	@Override
	public boolean newMove(int x, int y, int playerNum){ //takes user input for new move
		if(!(checkValid(x, y, this.gameBoard))) //makes sure that the input is valid
			return false;//will break out of this function if it isn't 
		if(playerNum == 0) //if CPU or player 2 you are X
			playerMoves[x][y] = 'X';
		else if(playerNum == 1)
			playerMoves[x][y] = 'O'; //If player 1 you are O
		else
			playerMoves[x][y] = 'X';
		moveCounter++; //increment the movecounter
		return true; //returns true only at the very end
	}
	
	
	@Override
	public boolean check(int playerNum){ //check for win conditions
		char player;
		if(playerNum == 1) //player one is O
			player = 'O';
		else
			player = 'X'; //player two is X
		for(int i = 0; i < 3; i++){ //checks vertical win conditions
			if(playerMoves[i][0] == playerMoves[i][1] && playerMoves[i][2] == playerMoves[i][0] && playerMoves[i][0] == player) //checks for vertical wins
				return true;
		}
		for(int i = 0; i < 3; i++){ //checks horizontal win conditions
			if(playerMoves[0][i] == playerMoves[1][i] && playerMoves[2][i] == playerMoves[0][i] && playerMoves[0][i] == player) //checks for horizontal wins
				return true;
		}
		//checks diagonal win condition
		if(playerMoves[0][0] == playerMoves[1][1] && playerMoves[2][2] == playerMoves[0][0] && playerMoves[0][0] == player) //checks for one diagonal win
			return true;
		//checks other diagonal win condition
		if(playerMoves[0][2] == playerMoves[1][1] && playerMoves[0][2] == playerMoves[2][0] && playerMoves[0][2] == player) //checks for other diagonal win
			return true;
		//if none of the conditions are true return false
		return false;
	}

	@Override
	public char[][] getGameBoard() {//returns playerBoard instead of gameBoard because tictactoe only uses the playerBoard
		return playerMoves;
	}

	@Override
	public void clearGameBoard() { //resets everything
		reset();
	}

	@Override
	public void updateBoard(int x, int y, char move) { //not even used in tictactoe
		
	}
}
