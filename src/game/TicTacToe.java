package game;

public class TicTacToe extends Game implements Grid{
	boolean twoPlayer;
	boolean cpuMove;
	int moveCounter;
	public TicTacToe(boolean twoPlayer){
		super(3,3);
		moveCounter = 0;
		cpuMove = false;
		this.twoPlayer = twoPlayer;
	}
	
	public boolean isPlayerOne(){
		if(twoPlayer){
			if((moveCounter%2) != 0)
				return true;
			else
				return false;
		}
		else{
			if(cpuMove)
				return false;
			else
				return true;
		}
	}
	
	@Override
	public boolean newMove(int x, int y, int playerNum){
		if(!(checkValid(x, y, this.gameBoard)))
			return false;
		if(playerNum == 0)
			playerMoves[x][y] = 'X';
		else if(playerNum == 1)
			playerMoves[x][y] = 'O';
		else
			playerMoves[x][y] = 'X';
		moveCounter++;
		return true;
	}
	
	
	@Override
	public boolean check(int playerNum){
		for(int i = 0; i < 3; i++){
			if(playerMoves[i][0] == playerMoves[i][1] && playerMoves[i][2] == playerMoves[i][0] && playerMoves[i][0] == playerNum) //checks for vertical wins
				return true;
		}
		for(int i = 0; i < 3; i++){
			if(playerMoves[0][i] == playerMoves[1][i] && playerMoves[2][i] == playerMoves[0][i] && playerMoves[0][i] == playerNum) //checks for horizontal wins
				return true;
		}
		
		if(playerMoves[0][0] == playerMoves[1][1] && playerMoves[2][2] == playerMoves[0][0] && playerMoves[0][0] == playerNum) //checks for one diagonal win
			return true;
		
		if(playerMoves[0][2] == playerMoves[1][1] && playerMoves[0][2] == playerMoves[2][0] && playerMoves[0][2] == playerNum) //checks for other diagonal win
			return true;
		
		return false;
	}

	@Override
	public char[][] getGameBoard() {
		return playerMoves;
	}

	@Override
	public void clearGameBoard() {
		reset();
	}
}
